package com.nanolabs.upgpainter.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.nanolabs.upgpainter.R
import com.nanolabs.upgpainter.data.data.ScreenItem
import com.nanolabs.upgpainter.ui.adapter.IntroViewPagerAdapter
import kotlinx.android.synthetic.main.activity_intro_slider.*
import java.util.*

class IntroSliderActivity : AppCompatActivity() {
   private lateinit var introViewPagerAdapter: IntroViewPagerAdapter
   var  position = 0
   lateinit var  btnAnim: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // make the activity on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        // when this activity is about to be launch we need to check if its opened before or not
        if (restorePrefData()) {
            val mainActivity = Intent(applicationContext, MainActivity::class.java)
            startActivity(mainActivity)
            finish()
        }

        setContentView(R.layout.activity_intro_slider)
        // hide the action bar
        supportActionBar!!.hide()
        btnAnim = AnimationUtils.loadAnimation(applicationContext,R.anim.button_animation)

        // setup viewpager
        val mList: MutableList<ScreenItem> = ArrayList()
        mList.add(
            ScreenItem(
                "Scan QR Code",
                "Grab paint bucket and scan QR code to earn rewards points.",
                R.drawable.undraw_directions
            )
        )
        mList.add(
            ScreenItem(
                "Visit Nearby Stores",
                "Visit nearby UPG retails shop and redeem items with your points.",
                R.drawable.undraw_directions
            )
        )
        mList.add(
            ScreenItem(
                "Earn More, Enjoy More",
                "Within the UPG app, earn more points and enjoy more rewards.",
                R.drawable.undraw_winners
            )
        )

        introViewPagerAdapter =
            IntroViewPagerAdapter(this, mList)
        screen_viewpager.adapter = introViewPagerAdapter

        // setup tab layout with viewpager
        tab_indicator.setupWithViewPager(screen_viewpager)

        // next button click Listner
        btn_next.setOnClickListener{
            position = screen_viewpager.currentItem
            if (position < mList.size) {
                position++
                screen_viewpager.currentItem =position
            }

            if (position == mList.size) { // when we rech to the last screen
                val mainActivity = Intent(applicationContext, MainActivity::class.java)
                startActivity(mainActivity)
                savePrefsData()
                finish()
            }
        }


        // skip button click listener
        tv_skip.setOnClickListener {
            position = mList.size
                val mainActivity = Intent(applicationContext, MainActivity::class.java)
                startActivity(mainActivity)
                savePrefsData()
                finish()

        }
    }

    private fun loaddLastScreen() {
        btn_next!!.visibility = View.INVISIBLE
       // btn_get_started!!.visibility = View.VISIBLE
        tv_skip!!.visibility = View.INVISIBLE
        tab_indicator!!.visibility = View.INVISIBLE

    }

    private fun savePrefsData() {
        val pref = applicationContext.getSharedPreferences(
            "myPrefs",
            Context.MODE_PRIVATE
        )
        val editor = pref.edit()
        editor.putBoolean("isIntroOpnend", true)
        editor.commit()
    }

    private fun restorePrefData(): Boolean {
        val pref = applicationContext.getSharedPreferences(
            "myPrefs",
            Context.MODE_PRIVATE
        )
        return pref.getBoolean("isIntroOpnend", false)
    }

}
