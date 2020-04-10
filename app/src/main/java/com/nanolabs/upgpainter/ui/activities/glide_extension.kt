package com.nanolabs.upgpainter.ui.activities

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nanolabs.upgpainter.R

fun ImageView.load(
    resource:Any,
    error : Int = R.drawable.ic_launcher_background,
    placeholder : Int = R.drawable.ic_launcher_background
){

    Glide.with(this.context).load(resource).apply(RequestOptions().placeholder(placeholder).error(error)).into(this)
}