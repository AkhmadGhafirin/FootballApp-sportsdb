package com.example.cascer.footballapp.ui.main.match.last

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cascer.footballapp.R
import com.example.cascer.footballapp.data.model.event.EventsItem
import com.example.cascer.footballapp.ui.main.match.detail.DetailMatchActivity
import com.example.cascer.footballapp.ui.main.match.MatchAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_last_match.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
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
//        presenter.getData()

        adapter = MatchAdapter(events) { toDetail(it) }
        initSwiperefresh()
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
        if (swipe != null && swipe.isRefreshing) terminateRefreshing(swipe)
        presenter.detachView()
        super.onDestroy()
    }

    override fun showData(list: List<EventsItem>?) {
        events.clear()
        list?.let { events.addAll(it) }
        adapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        swipe.isRefreshing = true
    }

    override fun hideLoading() {
        swipe.isRefreshing = false
    }

    override fun showMessage(message: String?) {
        toast(message.toString()).show()
    }

    override fun initRecyclerView() {
        rv_last.layoutManager = LinearLayoutManager(context)
        rv_last.adapter = adapter
    }

    private fun toDetail(data: EventsItem) {
        startActivity<DetailMatchActivity>(
            "event" to data
        )
    }

    override fun initSwiperefresh() {
        swipe.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.CYAN)
        swipe.setOnRefreshListener { presenter.getData() }
    }

    private fun terminateRefreshing(mSwpieRefresh: SwipeRefreshLayout?) {
        mSwpieRefresh?.isRefreshing = false
        mSwpieRefresh?.destroyDrawingCache()
        mSwpieRefresh?.clearAnimation()
    }
}