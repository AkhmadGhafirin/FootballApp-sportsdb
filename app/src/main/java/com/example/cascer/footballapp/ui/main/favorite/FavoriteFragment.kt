package com.example.cascer.footballapp.ui.main.favorite

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cascer.footballapp.R
import com.example.cascer.footballapp.data.model.event.EventsItem
import com.example.cascer.footballapp.data.model.favorite.Favorite
import com.example.cascer.footballapp.ui.main.match.detail.DetailMatchActivity
import com.example.cascer.footballapp.utils.invisible
import com.example.cascer.footballapp.utils.visible
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.jetbrains.anko.support.v4.startActivity
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 22, 2018.
 **/
class FavoriteFragment : Fragment(), FavoriteView {

    @Inject
    lateinit var presenter: FavoritePresenter

    private var favorites: MutableList<Favorite> = mutableListOf()

    private lateinit var adapter: FavoriteAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_favorite, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
//        presenter.getFavorite()

        adapter = FavoriteAdapter(favorites) { toDetail(it) }
        initSwipeRefresh()
        initRecyclerView()
    }

    override fun onResume() {
        presenter.attachView(this)
        presenter.getFavorite()
        super.onResume()
    }

    override fun onDestroy() {
        if (swipe != null && swipe.isRefreshing) terminateRefreshing(swipe)
        presenter.detachView()
        super.onDestroy()
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun initRecyclerView() {
        rv_favorite.layoutManager = LinearLayoutManager(context)
        rv_favorite.adapter = adapter
//        if (adapter.itemCount == null) {
//            row_empty.visible()
//        } else row_empty.invisible()
    }

    override fun showFavorites(list: List<Favorite>?) {
        favorites.clear()
        list?.let { favorites.addAll(it) }
        adapter.notifyDataSetChanged()

    }

    override fun showLoading() {
        swipe.isRefreshing = true
    }

    override fun hideLoading() {
        swipe.isRefreshing = false
    }

    override fun showMessage(message: String?) {
//        toast(message.toString()).show()
        Log.d("FavoriteFragment: ", message)
    }

    private fun toDetail(data: Favorite) {
        val event = EventsItem()
        event.idEvent = data.eventId.toString()
        event.dateEvent = data.dateEvent
        event.strTime = data.timeEvent
        event.strHomeTeam = data.homeTeamName
        event.intHomeScore = data.homeScore
        event.strHomeGoalDetails = data.homeGoalDetails
        event.strHomeLineupGoalkeeper = data.homeGoalKeeper
        event.strHomeLineupDefense = data.homeLineupDefense
        event.strHomeLineupMidfield = data.homeLineupMidField
        event.strHomeLineupForward = data.homeLineupForward
        event.strHomeLineupSubstitutes = data.homeLineupSubstitutes
        event.strHomeRedCards = data.homeRedCards
        event.strHomeYellowCards = data.homeYellowCards
        event.idHomeTeam = data.idHome
        event.strAwayTeam = data.awayTeamName
        event.intAwayScore = data.awayScore
        event.strAwayGoalDetails = data.awayGoalDetails
        event.strAwayLineupGoalkeeper = data.awayGoalKeeper
        event.strAwayLineupDefense = data.awayLineupDefense
        event.strAwayLineupMidfield = data.awayLineupMidField
        event.strAwayLineupForward = data.awayLineupForward
        event.strAwayLineupSubstitutes = data.awayLineupSubstitutes
        event.strAwayRedCards = data.awayRedCards
        event.strAwayYellowCards = data.awayYellowCards
        event.idAwayTeam = data.idAway

        startActivity<DetailMatchActivity>(
            "event" to event
        )
    }

    override fun initSwipeRefresh() {
        swipe.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.CYAN)
        swipe.setOnRefreshListener { presenter.getFavorite() }
    }

    private fun terminateRefreshing(mSwpieRefresh: SwipeRefreshLayout?) {
        mSwpieRefresh?.isRefreshing = false
        mSwpieRefresh?.destroyDrawingCache()
        mSwpieRefresh?.clearAnimation()
    }
}