package com.nanolabs.upgpainter.ui.fragments.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nanolabs.upgpainter.R
import com.nanolabs.upgpainter.data.data.Inbox
import com.nanolabs.upgpainter.ui.adapter.InboxAdapter


class InboxFragment : Fragment() {

    private lateinit var dashboardViewModel: InboxViewModel
    var list :ArrayList<Inbox> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(InboxViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_inbox, container, false)
//        val textView: TextView = root.findViewById(R.id.text_inbox)
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        list.add(Inbox("23 Feb 2020","Welcome! Thank you for signing up and explore what’s we offers."))
        list.add(Inbox("22 Feb 2020","Welcome! Thank you for signing up and explore what’s we offers."))
        list.add(Inbox("21 Feb 2020","Welcome! Thank you for signing up and explore what’s we offers."))
        list.add(Inbox("20 Feb 2020","Welcome! Thank you for signing up and explore what’s we offers."))
        list.add(Inbox("19 Feb 2020","Welcome! Thank you for signing up and explore what’s we offers."))
        list.add(Inbox("18 Feb 2020","Welcome! Thank you for signing up and explore what’s we offers."))
        list.add(Inbox("17 Feb 2020","Welcome! Thank you for signing up and explore what’s we offers."))
        list.add(Inbox("16 Feb 2020","Welcome! Thank you for signing up and explore what’s we offers."))
        list.add(Inbox("15 Feb 2020","Welcome! Thank you for signing up and explore what’s we offers."))
        list.add(Inbox("14 Feb 2020","Welcome! Thank you for signing up and explore what’s we offers."))

        var recyclerView : RecyclerView = root.findViewById(R.id.inboxRecycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        var inboxAdapter = context?.let {
            InboxAdapter(
                list,
                it
            )

        }
        recyclerView.adapter = inboxAdapter



        return root
    }
}
