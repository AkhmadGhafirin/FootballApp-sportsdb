package com.example.cascer.footballapp.base

import com.example.cascer.footballapp.data.network.Api
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import kotlin.math.log

/**
 *  Created by akhmad ghafirin on Nov 15, 2018.
 **/
abstract class NetPresenter<T : BaseView>(compositeDisposable: CompositeDisposable, api: Api) :
    BasePresenter<T>(compositeDisposable, api) {

    protected fun <V> observableSchedulers(): ObservableTransformer<V, V> {
        return ObservableTransformer<V, V> { upstream ->
            upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { /*mView?.showLoading()*/ }
                .doAfterTerminate { /*mView?.hideLoading()*/ }
        }
    }

    protected fun <V> singleSchedulers(): SingleTransformer<V, V> {
        return SingleTransformer { upstream ->
            upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { mView?.showLoading() }
                .doAfterTerminate { mView?.hideLoading() }
        }
    }

    protected fun processError(e: Throwable) {
        when (e) {
            is HttpException -> {
                val responseBody = e.response().errorBody()
                mView?.showMessage(responseBody?.string())
            }
            is SocketTimeoutException -> mView?.showMessage("Connection timed out.")
            is IOException -> mView?.showMessage("Connection lost, please check your connection.")
            else -> e.message?.let {
                mView?.showMessage(it)
            }
        }
    }
}