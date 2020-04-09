package com.nanolabs.upgpainter.ui.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nanolabs.upgpainter.R
import com.nanolabs.upgpainter.ui.adapter.SpinnerAdapter
import kotlinx.android.synthetic.main.activity_lanuage.*
import java.util.*

class LanuageActivity : AppCompatActivity() {

    internal var languageList = arrayOf("Myanmar ( Unicode )", "en")
    internal var images = intArrayOf(R.drawable.myanmar_flag, R.drawable.english_flag)
    lateinit var selectLanguage:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lanuage)

        loadLocale()

        // hide the action bar
        supportActionBar!!.hide()

//        btngetStart.setOnClickListener {  startActivity(Intent(this,IntroSliderActivity::class.java))}

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
               //Toast.makeText(this@LanuageActivity,"You Select Position: " + position + " " + languageList[position],Toast.LENGTH_LONG).show()
                selectLanguage=languageList[position]
//                if(languageList[position]=="Myanmar ( Unicode )"){
//                    setLocale("en")
//                    finish()
//                    startActivity(intent)
//                }else{
//                    setLocale("my")
//                    finish()
//                    startActivity(intent)
//                }

            }

        }

        val spinnerAdapter = SpinnerAdapter(applicationContext, images, languageList)
        spinner.adapter = spinnerAdapter

       // spinner.setSelection(languageList[])




        btngetStart.setOnClickListener {
            Toast.makeText(this@LanuageActivity,"You Select Position: " + selectLanguage,Toast.LENGTH_LONG).show()
            if(selectLanguage=="Myanmar ( Unicode )"){
                    setLocale("my")
                    finish()
                    startActivity(intent)
                }else{
                    setLocale("en")
                    finish()
                    startActivity(intent)
                }
            startActivity(Intent(this,IntroSliderActivity::class.java))
            finish()
        }
    }

    private fun setLocale(lang: String) {
        var locale : Locale = Locale(lang)
        Locale.setDefault(locale)
        var config : Configuration = Configuration()

        config.setLocale(locale)
        resources?.updateConfiguration(config, resources!!.displayMetrics)

        //save data to share preferences
        var editor : SharedPreferences.Editor? = getSharedPreferences("settings",Context.MODE_PRIVATE)?.edit()
        if (editor != null) {
            editor?.putString("My_Lang",lang)
        }
        editor?.apply()
    }

    //load language save in sharedPreference

    private fun loadLocale(){
        var prefes : SharedPreferences? = getSharedPreferences("settings",Context.MODE_PRIVATE)
        var language : String? = prefes?.getString("My_Lang","")
        Toast.makeText(applicationContext,language, Toast.LENGTH_LONG).show()
        if (language != null) {
            setLocale(language)
        }
    }

}

