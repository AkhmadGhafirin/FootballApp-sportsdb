package com.example.cascer.footballapp.ui.match

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.cascer.footballapp.R
import com.example.cascer.footballapp.ui.match.last.LastMatchFragment
import com.example.cascer.footballapp.ui.match.next.NextMatchFragment
import kotlinx.android.synthetic.main.activity_match.*

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
class MatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        createPager(viewpager)
        tab_match.setupWithViewPager(viewpager)
    }

    private fun createPager(pager: ViewPager) {
        val adapter = MatchPagerAdapter(supportFragmentManager)
        adapter.addFragment(NextMatchFragment(), getString(R.string.next_label))
        adapter.addFragment(LastMatchFragment(), getString(R.string.last_label))
        pager.adapter = adapter
    }
}
