package com.example.cascer.footballapp.ui.main.match.detail

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.cascer.footballapp.R
import com.example.cascer.footballapp.R.id.add_favorite
import com.example.cascer.footballapp.app.GlideApp
import com.example.cascer.footballapp.data.model.event.EventsItem
import com.example.cascer.footballapp.utils.invisible
import com.example.cascer.footballapp.utils.visible
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_detail_match.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
class DetailMatchActivity : AppCompatActivity(), DetailMatchView {

    @Inject
    lateinit var presenter: DetailMatchPresenter

    private lateinit var event: EventsItem

    private var isFavorite: Boolean = false
    private var menuItem: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        event = intent.getParcelableExtra("event")

        supportActionBar?.title = "Match Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter.attachView(this)
        presenter.checkIsFavorite(event.idEvent.toLong())
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            add_favorite -> {
                if (isFavorite) removeFromFavorite() else addToFavorite()

                isFavorite = !isFavorite
                setupFavorite()

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun removeFromFavorite() {
        presenter.removeFromDB(event.idEvent)
    }

    private fun setupFavorite() {
        if (isFavorite) menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_black_24dp)
        else menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_border_black_24dp)
    }

    private fun addToFavorite() {
        presenter.insertToDB(event)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu_item, menu)
        menuItem = menu
        setupFavorite()
        return true
    }

    override fun showDetail(data: EventsItem?, urlLogoHome: String?, urlLogoAway: String?) {
        tv_schedule.text = data?.dateEvent

        GlideApp.with(this)
            .load(urlLogoHome)
            .dontAnimate()
            .into(iv_home)
        tv_home.text = data?.strHomeTeam ?: ""
        tv_score_home.text = data?.intHomeScore ?: ""
        tv_goal_home.text = data?.strHomeGoalDetails ?: ""
        tv_shot_home.text = data?.intHomeShots ?: ""
        tv_keeper_home.text = data?.strHomeLineupGoalkeeper ?: ""
        tv_defense_home.text = data?.strHomeLineupDefense ?: ""
        tv_midfield_home.text = data?.strHomeLineupMidfield ?: ""
        tv_forward_home.text = data?.strHomeLineupForward ?: ""
        tv_substitutes_home.text = data?.strHomeLineupSubstitutes ?: ""

        GlideApp.with(this)
            .load(urlLogoAway)
            .dontAnimate()
            .into(iv_away)
        tv_away.text = data?.strAwayTeam ?: ""
        tv_score_away.text = data?.intAwayScore ?: ""
        tv_goal_away.text = data?.strAwayGoalDetails ?: ""
        tv_shot_away.text = data?.intAwayShots ?: ""
        tv_keeper_away.text = data?.strAwayLineupGoalkeeper ?: ""
        tv_defense_away.text = data?.strAwayLineupDefense ?: ""
        tv_midfield_away.text = data?.strAwayLineupMidfield ?: ""
        tv_forward_away.text = data?.strAwayLineupForward ?: ""
        tv_substitutes_away.text = data?.strAwayLineupSubstitutes ?: ""
    }

    override fun showLoading() {
        progress.visible()
    }

    override fun hideLoading() {
        progress.invisible()
    }

    override fun showMessage(message: String?) {
        toast(message.toString()).show()
    }

    override fun isFavorite(isFavorite: Boolean) {
        this.isFavorite = isFavorite
    }
}
