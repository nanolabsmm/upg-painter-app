package com.nanolabs.upgpainter.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nanolabs.upgpainter.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.comfirm_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       supportActionBar!!.hide()

        btnSend.setOnClickListener {
            layout_login.visibility = View.GONE
            layout_comfirm.visibility = View.VISIBLE
        }

        btnComfirm.setOnClickListener {
            startActivity(Intent(this,ChooseRegisterActivity::class.java))
            finish()
        }


    }
}
