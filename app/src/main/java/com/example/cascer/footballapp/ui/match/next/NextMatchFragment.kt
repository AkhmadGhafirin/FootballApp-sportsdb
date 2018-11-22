package com.example.cascer.footballapp.ui.match.next

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
import kotlinx.android.synthetic.main.fragment_next_match.*
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
class NextMatchFragment : Fragment(), NextMatchView {

    @Inject
    lateinit var presenter: NextMatchPresenter

    private var events: MutableList<EventsItem> = mutableListOf()

    private lateinit var adapter: MatchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_next_match, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        presenter.getData()

        adapter = MatchAdapter(events) { toDetail(it) }
        initRecyclerView()
    }

    override fun onResume() {
        presenter.getData()
        super.onResume()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
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
        rv_next.layoutManager = LinearLayoutManager(context)
        rv_next.adapter = adapter
    }

    private fun toDetail(data: EventsItem) {
        val intent = Intent(context, DetailMatchActivity::class.java)
        intent.putExtra("event", data)
        startActivity(intent)
    }
}