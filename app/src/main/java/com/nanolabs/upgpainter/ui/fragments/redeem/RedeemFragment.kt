package com.nanolabs.upgpainter.ui.fragments.redeem

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.nanolabs.upgpainter.R
import com.nanolabs.upgpainter.data.api.ApiInterface
import com.nanolabs.upgpainter.data.api.ApiResponse
import com.nanolabs.upgpainter.data.api.Common
import com.nanolabs.upgpainter.data.data.ScreenItem1
import com.nanolabs.upgpainter.ui.adapter.IntroViewPagerAdapter1
import com.nanolabs.upgpainter.ui.adapter.MyItemGroupAdapter
import kotlinx.android.synthetic.main.activity_intro_slider.view.*
import kotlinx.android.synthetic.main.activity_intro_slider.view.tab_indicator
import kotlinx.android.synthetic.main.fragment_redeem.*
import kotlinx.android.synthetic.main.fragment_redeem.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList



class RedeemFragment : Fragment() {
    internal lateinit var mService: ApiInterface
    lateinit var dataGroupList: ArrayList<ApiResponse>
    lateinit var progressDialog:ProgressDialog

    private lateinit var introViewPagerAdapter: IntroViewPagerAdapter1
    var  position = 0
    private lateinit var dashboardViewModel: RedeemViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(RedeemViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_redeem, container, false)
        //val textView: TextView = root.findViewById(R.id.text_redeem)
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        //init service
        mService = Common.api
        dataGroupList = ArrayList()

        progressDialog = ProgressDialog(context)
        progressDialog.setTitle("Loading Data");
        progressDialog.setMessage("Please Wait.....");

        progressDialog.show()
       mService.getData().enqueue(object :Callback<List<ApiResponse>>{
           override fun onFailure(call: Call<List<ApiResponse>>, t: Throwable) {
               progressDialog.dismiss()
               Toast.makeText(
                   context,
                  t.message,
                   Toast.LENGTH_LONG
               ).show()
           }

           override fun onResponse(call: Call<List<ApiResponse>>, response: Response<List<ApiResponse>>) {
               progressDialog.dismiss()
               dataGroupList = response.body() as ArrayList<ApiResponse>

               Log.d("OUTPUT", dataGroupList.size.toString())

               var myItemGroupAdapter= MyItemGroupAdapter(dataGroupList,context)
               root.my_recycler_view.adapter = myItemGroupAdapter
           }

       })

        root.my_recycler_view.setHasFixedSize(true)
        root.my_recycler_view.layoutManager = LinearLayoutManager(context)
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



        return root
    }
}
