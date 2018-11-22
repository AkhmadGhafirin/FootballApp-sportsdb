package com.example.cascer.footballapp.ui.detail

import com.example.cascer.footballapp.base.NetPresenter
import com.example.cascer.footballapp.data.model.event.EventsItem
import com.example.cascer.footballapp.data.model.team.TeamsItem
import com.example.cascer.footballapp.data.network.Api
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
class DetailMatchPresenter
@Inject constructor(compositeDisposable: CompositeDisposable, api: Api) :
    NetPresenter<DetailMatchView>(compositeDisposable, api) {

    private lateinit var eventsItem: EventsItem
    private var urlLogoHome: String? = ""

    fun getDetail(data: EventsItem) {
        this.eventsItem = data

        getHome(data.idHomeTeam, data.idAwayTeam)
    }

    private fun getHome(idHome: String?, idAway: String?) {
        compositeDisposable.add(
            api.getTeamDetail(idHome)
                .map { team -> team.teamsItems }
                .compose(singleSchedulers())
                .subscribe(
                    {
                        getAway(idAway, it)
                    },
                    this::processError
                )
        )
    }

    private fun getAway(idAway: String?, data: List<TeamsItem>?) {
        urlLogoHome = data?.get(0)?.strTeamBadge
        compositeDisposable.add(
            api.getTeamDetail(idAway)
                .map { team -> team.teamsItems }
                .compose(singleSchedulers())
                .subscribe(
                    {
                        run {
                            mView?.showDetail(eventsItem, urlLogoHome, it?.get(0)?.strTeamBadge)
                        }
                    }, this::processError
                )
        )
    }
}