package com.example.cascer.footballapp.ui.detail

import com.example.cascer.footballapp.base.BaseView
import com.example.cascer.footballapp.data.model.event.EventsItem
import com.example.cascer.footballapp.data.model.team.TeamsItem

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
interface DetailMatchView : BaseView {
    fun showDetail(data: EventsItem?, urlLogoHome: String?, urlLogoAway: String?)
}