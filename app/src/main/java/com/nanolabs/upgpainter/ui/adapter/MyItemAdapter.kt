package com.nanolabs.upgpainter.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nanolabs.upgpainter.R
import com.nanolabs.upgpainter.data.data.ItemData
import com.nanolabs.upgpainter.ui.activities.ItemClickListener
import com.nanolabs.upgpainter.ui.activities.load
import kotlinx.android.synthetic.main.layout_item.view.*

class MyItemAdapter(val dataItemList: ArrayList<ItemData>?, val context:Context ) : RecyclerView.Adapter<MyItemAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text_item_title:Button = itemView.tvTitle as Button
        var image_item = itemView.itemImage
        lateinit var myItemClickListener : ItemClickListener

        init {
            itemView.setOnClickListener {
                myItemClickListener.onItemClickListener(it,adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyItemAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_raw_redeem, parent, false))

    }

    override fun getItemCount(): Int {
        //return if((dataItemList.size!=null)) dataItemList.size else 0
        return dataItemList?.size!!
        //Toast.makeText(context,dataItemList?.size.toString(),Toast.LENGTH_LONG).show()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.text_item_title.text = dataItemList?.get(position)?.name.toString() + " points"
        //Picasso.get().load(dataItemList?.get(position)?.image).into(holder.image_item)
        dataItemList?.get(position)?.image?.let { holder.image_item.load(it) }




        holder.myItemClickListener = object : ItemClickListener {
            override fun onItemClickListener(view: View, position: Int) {
                Toast.makeText(context,dataItemList?.get(position)?.name.toString(),Toast.LENGTH_LONG).show()
            }
        }

    }
}