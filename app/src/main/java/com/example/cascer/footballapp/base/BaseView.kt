package com.example.cascer.footballapp.base

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
interface BaseView {
    fun showLoading()

    fun hideLoading()

    fun showMessage(message: String?)
}