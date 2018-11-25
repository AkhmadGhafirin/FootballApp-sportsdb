package com.example.cascer.footballapp.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.cascer.footballapp.R
import com.example.cascer.footballapp.R.id.*
import com.example.cascer.footballapp.ui.main.favorite.FavoriteFragment
import com.example.cascer.footballapp.ui.main.match.last.LastMatchFragment
import com.example.cascer.footballapp.ui.main.match.next.NextMatchFragment
import com.example.cascer.footballapp.ui.main.team.TeamFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNav()
        openFragment(LastMatchFragment())
    }

    private fun setupBottomNav() {
        bottom_nav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                pasts -> {
                    openFragment(LastMatchFragment())
                }
                nexts -> {
                    openFragment(NextMatchFragment())
                }
                teams -> {
                    openFragment(TeamFragment())
                }
                favorites -> {
                    openFragment(FavoriteFragment())
                }
            }
            true
        }
        bottom_nav.selectedItemId
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}
