package com.example.cascer.footballapp.ui.main.team

import com.example.cascer.footballapp.base.NetPresenter
import com.example.cascer.footballapp.data.network.Api
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 22, 2018.
 **/
class TeamPresenter @Inject constructor(compositeDisposable: CompositeDisposable, api: Api) :
    NetPresenter<TeamView>(compositeDisposable, api) {

    /*private fun getLeagues() {
        compositeDisposable.add(
            api.getLeagues()
                .compose(singleSchedulers())
                .subscribe(
                    {
                        var string: String
                    }, this::processError
                )
        )
    }*/

    fun getData() {
        compositeDisposable.add(
            api.getTeams()
                .compose(singleSchedulers())
                .subscribe(
                    {
                        mView?.showData(it.teams)
                    }, this::processError
                )
        )
    }
}