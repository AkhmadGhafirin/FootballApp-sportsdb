package com.example.cascer.footballapp.ui.main.team

import com.example.cascer.footballapp.base.BaseView
import com.example.cascer.footballapp.data.model.team.list.TeamsItem

/**
 *  Created by akhmad ghafirin on Nov 22, 2018.
 **/
interface TeamView : BaseView {
    fun initRecyclerView()
    fun initSwiperefresh()
    fun showData(list: List<TeamsItem>?)
}