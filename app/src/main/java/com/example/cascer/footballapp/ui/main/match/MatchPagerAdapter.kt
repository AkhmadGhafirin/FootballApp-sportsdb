package com.example.cascer.footballapp.ui.main.match

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 *  Created by akhmad ghafirin on Nov 16, 2018.
 **/
class MatchPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val mFragments: ArrayList<Fragment> = ArrayList()
    private val mTitleList: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment = mFragments[position]

    override fun getCount(): Int = mFragments.size

    fun addFragment(fragment: Fragment, title: String) {
        mFragments.add(fragment)
        mTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence = mTitleList[position]
}