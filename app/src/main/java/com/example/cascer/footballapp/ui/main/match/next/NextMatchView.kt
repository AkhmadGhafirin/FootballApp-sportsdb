package com.example.cascer.footballapp.ui.main.match.next

import com.example.cascer.footballapp.base.BaseView
import com.example.cascer.footballapp.data.model.event.EventsItem

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
interface NextMatchView : BaseView {
    fun initRecyclerView()
    fun initSwiperefresh()
    fun showData(list: List<EventsItem>?)
}