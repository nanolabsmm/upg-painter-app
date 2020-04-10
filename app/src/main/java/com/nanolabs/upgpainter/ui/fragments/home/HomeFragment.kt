package com.nanolabs.upgpainter.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.nanolabs.upgpainter.R
import com.nanolabs.upgpainter.data.data.ScreenItem1
import com.nanolabs.upgpainter.ui.adapter.IntroViewPagerAdapter1
import kotlinx.android.synthetic.main.activity_intro_slider.view.tab_indicator
import java.util.ArrayList


class HomeFragment : Fragment() {
    private lateinit var introViewPagerAdapter: IntroViewPagerAdapter1
    var  position = 0
    lateinit var  btnAnim: Animation
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
       // val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        // setup viewpager
        val mList: MutableList<ScreenItem1> = ArrayList()
        mList.add(ScreenItem1(R.drawable.gift_banner1))
        mList.add(ScreenItem1(R.drawable.undraw_directions))
        mList.add(ScreenItem1(R.drawable.undraw_winners))

        var homeBanner = root.findViewById<ViewPager>(R.id.homeBannerViewpager)
        introViewPagerAdapter =
            context?.let { IntroViewPagerAdapter1(it, mList) }!!
        homeBanner.adapter = introViewPagerAdapter

        // setup tab layout with viewpager
        root.tab_indicator.setupWithViewPager(homeBanner)

        // next button click Listner
//        root.btn_next.setOnClickListener{
//            position = screen_viewpager.currentItem
//            if (position < mList.size) {
//                position++
//                screen_viewpager.currentItem =position
//            }
//
//            if (position == mList.size) { // when we rech to the last screen
//                val mainActivity = Intent(context, MainActivity::class.java)
//                startActivity(mainActivity)
//               // savePrefsData()
//                activity?.finish()
//            }
//        }


        // skip button click listener
//        root.tv_skip.setOnClickListener {
//            position = mList.size
//            val mainActivity = Intent(context, MainActivity::class.java)
//            startActivity(mainActivity)
//            //savePrefsData()
//            activity?.finish()
//
//        }


        return root
    }
}
