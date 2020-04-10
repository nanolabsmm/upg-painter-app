package com.nanolabs.upgpainter.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.nanolabs.upgpainter.R
import com.nanolabs.upgpainter.data.data.ScreenItem1

class IntroViewPagerAdapter1(
    var mContext: Context,
    var mListScreen: List<ScreenItem1>
) :
    PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layoutScreen = inflater.inflate(R.layout.layout_screen1, null)
        val imgSlide =
            layoutScreen.findViewById<ImageView>(R.id.intro_img)
        imgSlide.setImageResource(mListScreen[position].ScreenImg)
        container.addView(layoutScreen)
        return layoutScreen
    }

    override fun getCount(): Int {
        return mListScreen.size
    }

    override fun isViewFromObject(
        view: View,
        `object`: Any
    ): Boolean {
        return view === `object`
    }

    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        container.removeView(`object` as View)
    }

}
