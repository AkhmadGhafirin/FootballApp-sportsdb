package com.example.cascer.footballapp.ui.main.favorite

import com.example.cascer.footballapp.data.db.DBHelper
import com.example.cascer.footballapp.data.model.favorite.Favorite
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 22, 2018.
 **/
class FavoritePresenter
@Inject constructor(private val dbHelper: DBHelper) {

    protected var mView: FavoriteView? = null

    fun getFavorite() {
        mView?.showLoading()
        try {
            mView?.hideLoading()
            dbHelper.use {
                val result = select(Favorite.TABLE_FAVORITE)
                val data = result.parseList(classParser<Favorite>())
                mView?.showFavorites(data)
            }
        } catch (e: Exception) {
            mView?.showMessage(e.localizedMessage)
        }
    }

    fun attachView(view: FavoriteView) {
        this.mView = view
    }

    fun detachView() {
        mView = null
    }
}