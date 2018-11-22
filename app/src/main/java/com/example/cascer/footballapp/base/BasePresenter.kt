package com.example.cascer.footballapp.base

import com.example.cascer.footballapp.data.network.Api
import io.reactivex.disposables.CompositeDisposable

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
open class BasePresenter<T>(protected val compositeDisposable: CompositeDisposable,
                            protected var api: Api) {

    protected var mView: T? = null

    fun attachView(view: T) {
        this.mView = view
    }

    fun detachView() {
        compositeDisposable.dispose()
        mView = null
    }
}