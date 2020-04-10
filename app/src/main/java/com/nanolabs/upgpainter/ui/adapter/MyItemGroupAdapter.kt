package com.nanolabs.upgpainter.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nanolabs.upgpainter.R
import com.nanolabs.upgpainter.data.api.ApiResponse
import com.nanolabs.upgpainter.data.data.ItemData
import kotlinx.android.synthetic.main.layout_group.view.*


class MyItemGroupAdapter(
    private val dataList: ArrayList<ApiResponse>,
    private val context: Context?
) :
    RecyclerView.Adapter<MyItemGroupAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTitle = itemView.itemGroupText!!
        var recyclerViewList = itemView.groupRecyclerView!!
        var textMore = itemView.textMore!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_group,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = dataList.size
    //return if((dataList.size!=null)) dataList.size else 0


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemTitle.text = dataList[position].getHeaderTitle ?: "NULL"
        val itemData: ArrayList<ItemData> = dataList[position].getListItem ?: arrayListOf()

        val myItemAdapter = context?.let { MyItemAdapter(itemData, it) }
        holder.recyclerViewList.setHasFixedSize(true)
        holder.recyclerViewList.adapter = myItemAdapter
        holder.recyclerViewList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerViewList.isNestedScrollingEnabled = false

        holder.textMore.setOnClickListener {
            Toast.makeText(context, "btn More : " + holder.itemTitle, Toast.LENGTH_LONG).show()
        }
    }
}