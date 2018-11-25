package com.example.cascer.footballapp.ui.main.favorite

import com.example.cascer.footballapp.data.model.favorite.Favorite

/**
 *  Created by akhmad ghafirin on Nov 22, 2018.
 **/
interface FavoriteView {
    fun initRecyclerView()
    fun initSwipeRefresh()
    fun showFavorites(list: List<Favorite>?)
    fun showLoading()
    fun hideLoading()
    fun showMessage(message: String?)
}