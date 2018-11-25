package com.example.cascer.footballapp.ui.main.match.detail

import com.example.cascer.footballapp.base.BaseView
import com.example.cascer.footballapp.data.model.event.EventsItem

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
interface DetailMatchView : BaseView {
    fun showDetail(data: EventsItem?, urlLogoHome: String?, urlLogoAway: String?)
    fun isFavorite(isFavorite: Boolean)
}