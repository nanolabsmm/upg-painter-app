package com.nanolabs.upgpainter.ui.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.journeyapps.barcodescanner.CaptureActivity
import com.journeyapps.barcodescanner.DecoratedBarcodeView
import com.nanolabs.upgpainter.R
import kotlinx.android.synthetic.main.activity_small_capture.*

class SmallCaptureActivity : CaptureActivity() {

    override fun initializeContent(): DecoratedBarcodeView {
        setContentView(R.layout.activity_small_capture)

        qrScanBackLayout.setOnClickListener {
            finish()
        }
        return findViewById<View>(R.id.zxing_barcode_scanner) as DecoratedBarcodeView

    }




}
