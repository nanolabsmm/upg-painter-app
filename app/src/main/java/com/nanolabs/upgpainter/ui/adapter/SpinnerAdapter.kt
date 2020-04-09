package com.nanolabs.upgpainter.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nanolabs.upgpainter.R

class SpinnerAdapter(var context: Context,var images: IntArray,var fruit: Array<String>) :BaseAdapter(){

    var inflter: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       val view = inflter.inflate(R.layout.spinner_custom_layout,null)
        val icon = view.findViewById<View>(R.id.imageSpinner) as ImageView
        val name = view.findViewById<View>(R.id.textSpinner) as TextView
        icon.setImageResource(images[position])
        name.text = fruit[position]

        return view
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return images.size
    }
}