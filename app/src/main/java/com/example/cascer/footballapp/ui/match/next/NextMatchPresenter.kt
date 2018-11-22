package com.example.cascer.footballapp.ui.match.next

import com.example.cascer.footballapp.base.NetPresenter
import com.example.cascer.footballapp.data.network.Api
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
class NextMatchPresenter
@Inject constructor(compositeDisposable: CompositeDisposable, api: Api) :
    NetPresenter<NextMatchView>(compositeDisposable, api) {

    fun getData() {
        compositeDisposable.add(
            api.getNextEvent()
                .compose(singleSchedulers())
                .subscribe(
                    {
                        mView?.showData(it.events)
                    },
                    this::processError
                )
        )
    }
}