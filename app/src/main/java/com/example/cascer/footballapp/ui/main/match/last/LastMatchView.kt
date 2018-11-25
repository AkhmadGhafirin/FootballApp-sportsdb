package com.example.cascer.footballapp.ui.main.match.last

import com.example.cascer.footballapp.base.BaseView
import com.example.cascer.footballapp.data.model.event.EventsItem

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
interface LastMatchView : BaseView {
    fun initRecyclerView()
    fun initSwiperefresh()
    fun showData(list: List<EventsItem>?)
}