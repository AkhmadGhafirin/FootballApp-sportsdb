package com.example.cascer.footballapp.ui.match.last

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cascer.footballapp.R
import com.example.cascer.footballapp.data.model.event.EventsItem
import com.example.cascer.footballapp.ui.detail.DetailMatchActivity
import com.example.cascer.footballapp.ui.match.MatchAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_last_match.*
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
class LastMatchFragment : Fragment(), LastMatchView {

    @Inject
    lateinit var presenter: LastMatchPresenter

    private var events: MutableList<EventsItem> = mutableListOf()

    private lateinit var adapter: MatchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_last_match, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        presenter.attachView(this)
        presenter.getData()

        adapter = MatchAdapter(events) { toDetail(it) }
        initRecyclerView()
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
        presenter.getData()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun showData(list: List<EventsItem>?) {
        events.clear()
        list?.let { events.addAll(it) }
        adapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.INVISIBLE
    }

    override fun showMessage(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun initRecyclerView() {
        rv_last.layoutManager = LinearLayoutManager(context)
        rv_last.adapter = adapter
    }

    private fun toDetail(data: EventsItem) {
        val intent = Intent(context, DetailMatchActivity::class.java)
        intent.putExtra("event", data)
        startActivity(intent)
    }
}