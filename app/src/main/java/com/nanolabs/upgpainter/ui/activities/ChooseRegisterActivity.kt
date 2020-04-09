package com.nanolabs.upgpainter.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nanolabs.upgpainter.R
import kotlinx.android.synthetic.main.activity_choose_register.*

class ChooseRegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_register)

        supportActionBar!!.hide()

        personal_card.setOnClickListener {
            startActivity(Intent(this,PersonalRegisterActivity::class.java))
            finish()
        }

        company_card.setOnClickListener {
            startActivity(Intent(this,CompanyRegisterActivity::class.java))
            finish()
        }
    }
}
