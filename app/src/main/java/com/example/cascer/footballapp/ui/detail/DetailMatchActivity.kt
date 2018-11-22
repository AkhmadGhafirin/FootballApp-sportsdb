package com.example.cascer.footballapp.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.cascer.footballapp.R
import com.example.cascer.footballapp.app.GlideApp
import com.example.cascer.footballapp.data.model.event.EventsItem
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_detail_match.*
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
class DetailMatchActivity : AppCompatActivity(), DetailMatchView {

    @Inject
    lateinit var presenter: DetailMatchPresenter

    private lateinit var event: EventsItem

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        event = intent.getParcelableExtra("event")

        supportActionBar?.title = "Detail Match"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter.attachView(this)
        presenter.getDetail(event)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onResume() {
        super.onResume()
        presenter.getDetail(event)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun showDetail(data: EventsItem?, urlLogoHome: String?, urlLogoAway: String?) {
        tv_schedule.text = data?.dateEvent

        GlideApp.with(this)
            .load(urlLogoHome)
            .dontAnimate()
            .into(iv_home)
        tv_home.text = data?.strHomeTeam ?: "-"
        tv_score_home.text = data?.intHomeScore ?: "-"
        tv_goal_home.text = data?.strHomeGoalDetails ?: "-"
        tv_shot_home.text = data?.intHomeShots ?: "-"
        tv_keeper_home.text = data?.strHomeLineupGoalkeeper ?: "-"
        tv_defense_home.text = data?.strHomeLineupDefense ?: "-"
        tv_midfield_home.text = data?.strHomeLineupMidfield ?: "-"
        tv_forward_home.text = data?.strHomeLineupForward ?: "-"
        tv_substitutes_home.text = data?.strHomeLineupSubstitutes ?: "-"

        GlideApp.with(this)
            .load(urlLogoAway)
            .dontAnimate()
            .into(iv_away)
        tv_away.text = data?.strAwayTeam ?: "-"
        tv_score_away.text = data?.intAwayScore ?: "-"
        tv_goal_away.text = data?.strAwayGoalDetails ?: "-"
        tv_shot_away.text = data?.intAwayShots ?: "-"
        tv_keeper_away.text = data?.strAwayLineupGoalkeeper ?: "-"
        tv_defense_away.text = data?.strAwayLineupDefense ?: "-"
        tv_midfield_away.text = data?.strAwayLineupMidfield ?: "-"
        tv_forward_away.text = data?.strAwayLineupForward ?: "-"
        tv_substitutes_away.text = data?.strAwayLineupSubstitutes ?: "-"
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.INVISIBLE
    }

    override fun showMessage(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
