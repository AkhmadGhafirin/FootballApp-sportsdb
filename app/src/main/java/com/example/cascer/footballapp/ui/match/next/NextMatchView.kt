package com.example.cascer.footballapp.ui.match.next

import com.example.cascer.footballapp.base.BaseView
import com.example.cascer.footballapp.data.model.event.EventsItem
import com.example.cascer.footballapp.data.model.event.EventList

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
interface NextMatchView : BaseView {
    fun initRecyclerView()
    fun showData(list: List<EventsItem>?)
}