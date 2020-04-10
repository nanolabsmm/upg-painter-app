package com.nanolabs.upgpainter.ui.fragments.scan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScanViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is test Fragment"

    }
    val text: LiveData<String> = _text
}