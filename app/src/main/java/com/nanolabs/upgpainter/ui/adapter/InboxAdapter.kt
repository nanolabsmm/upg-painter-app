package com.nanolabs.upgpainter.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nanolabs.upgpainter.R
import com.nanolabs.upgpainter.data.data.Inbox
import com.nanolabs.upgpainter.ui.fragments.inbox.InboxFragment
import kotlinx.android.synthetic.main.layout_inbox_raw.view.*

class InboxAdapter(val inboxList: ArrayList<Inbox>, val context: Context) : RecyclerView.Adapter<InboxAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       var inbox_date = view.inboxDate
        var inbox_text = view.inboxTitle
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_inbox_raw,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
       return inboxList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.inbox_date.text = inboxList[position].inboxDate
        holder.inbox_text.text = inboxList[position].inboxText
    }
}