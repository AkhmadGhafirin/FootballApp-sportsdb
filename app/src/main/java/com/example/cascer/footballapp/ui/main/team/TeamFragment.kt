package com.example.cascer.footballapp.ui.main.team

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cascer.footballapp.R
import com.example.cascer.footballapp.data.model.team.list.TeamsItem
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_team.*
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 22, 2018.
 **/
class TeamFragment : Fragment(), TeamView {

    @Inject
    lateinit var presenter: TeamPresenter

    private var teams: MutableList<TeamsItem> = mutableListOf()

    private lateinit var adapter: TeamAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_team, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
//        presenter.getData()

        adapter = TeamAdapter(teams) {}
        initSwiperefresh()
        initRecyclerView()
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onResume() {
        presenter.attachView(this)
        presenter.getData()
        super.onResume()
    }

    override fun onDestroy() {
        if (swipe != null && swipe.isRefreshing) terminateRefreshing(swipe)
        presenter.detachView()
        super.onDestroy()
    }

    override fun initRecyclerView() {
        rv_team.layoutManager = LinearLayoutManager(context)
        rv_team.adapter = adapter
    }

    override fun initSwiperefresh() {
        swipe.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.CYAN)
        swipe.setOnRefreshListener { presenter.getData() }
    }

    override fun showData(list: List<TeamsItem>?) {
        teams.clear()
        list?.let { teams.addAll(it) }
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

    private fun terminateRefreshing(mSwpieRefresh: SwipeRefreshLayout?) {
        mSwpieRefresh?.isRefreshing = false
        mSwpieRefresh?.destroyDrawingCache()
        mSwpieRefresh?.clearAnimation()
    }
}