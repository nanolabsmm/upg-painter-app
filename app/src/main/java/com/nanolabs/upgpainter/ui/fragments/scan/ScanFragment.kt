package com.nanolabs.upgpainter.ui.fragments.scan

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.zxing.integration.android.IntentIntegrator
import com.nanolabs.upgpainter.R
import com.nanolabs.upgpainter.ui.activities.SmallCaptureActivity
import kotlinx.android.synthetic.main.fragment_scan.view.*

class ScanFragment : Fragment() {

    private lateinit var notificationsViewModel: ScanViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProviders.of(this).get(ScanViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_scan, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

      root.Scan.setOnClickListener {

//          var scannerIntegrator = IntentIntegrator.forSupportFragment(this)
//          scannerIntegrator.setOrientationLocked(false)
//          scannerIntegrator.captureActivity = SmallCaptureActivity::class.java
//          scannerIntegrator.initiateScan()

          var scannerIntegrator = IntentIntegrator.forSupportFragment(this)
          scannerIntegrator.captureActivity = SmallCaptureActivity::class.java
          scannerIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
          scannerIntegrator.setPrompt("Scan QR Code")
          scannerIntegrator.setBeepEnabled(true)
          scannerIntegrator.setOrientationLocked(false)
          scannerIntegrator.initiateScan()
      }
        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if(intentResult.contents!=null){
            Toast.makeText(context,intentResult.contents.toString(),Toast.LENGTH_LONG).show()
        }
    }
}
