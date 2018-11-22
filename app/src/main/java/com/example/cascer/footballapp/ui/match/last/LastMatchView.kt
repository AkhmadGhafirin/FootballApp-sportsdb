package com.example.cascer.footballapp.ui.match.last

import com.example.cascer.footballapp.base.BaseView
import com.example.cascer.footballapp.data.model.event.EventsItem
import com.example.cascer.footballapp.data.model.event.EventList

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
interface LastMatchView : BaseView {
    fun initRecyclerView()
    fun showData(list: List<EventsItem>?)
}