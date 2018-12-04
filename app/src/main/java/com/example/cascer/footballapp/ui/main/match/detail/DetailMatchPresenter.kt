package com.example.cascer.footballapp.ui.main.match.detail

import android.database.sqlite.SQLiteConstraintException
import com.example.cascer.footballapp.base.NetPresenter
import com.example.cascer.footballapp.data.db.DBHelper
import com.example.cascer.footballapp.data.model.event.EventsItem
import com.example.cascer.footballapp.data.model.favorite.Favorite
import com.example.cascer.footballapp.data.model.team.detail.TeamDetailItem
import com.example.cascer.footballapp.data.network.Api
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.db.*
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
class DetailMatchPresenter
@Inject constructor(compositeDisposable: CompositeDisposable, api: Api, val dbHelper: DBHelper) :
    NetPresenter<DetailMatchView>(compositeDisposable, api) {

    private lateinit var eventsItem: EventsItem
    private var urlLogoHome: String? = ""

    fun getDetail(data: EventsItem) {
        this.eventsItem = data

        getHome(data.idHomeTeam, data.idAwayTeam)
    }

     fun getHome(idHome: String?, idAway: String?) {
        compositeDisposable.add(
            api.getTeamDetail(idHome)
                .map { team -> team.teamsItems }
                .compose(singleSchedulers())
                .subscribe(
                    {
                        getAway(idAway, it)
                    },
                    this::processError
                )
        )
    }

    fun getAway(idAway: String?, data: List<TeamDetailItem>?) {
        urlLogoHome = data?.get(0)?.strTeamBadge
        compositeDisposable.add(
            api.getTeamDetail(idAway)
                .map { team -> team.teamsItems }
                .compose(singleSchedulers())
                .subscribe(
                    {
                        run {
                            mView?.showDetail(eventsItem, urlLogoHome, it?.get(0)?.strTeamBadge)
                        }
                    }, this::processError
                )
        )
    }

    fun insertToDB(data: EventsItem) {
        try {
            dbHelper.use {
                insert(
                    Favorite.TABLE_FAVORITE,
                    Favorite.EVENT_ID to data.idEvent,
                    Favorite.EVENT_DATE to data.dateEvent,
                    Favorite.EVENT_TIME to data.strTime,
                    Favorite.HOME_TEAM_NAME to data.strHomeTeam,
                    Favorite.HOME_SCORE to data.intHomeScore,
                    Favorite.HOME_GOAL_DETAILS to data.strHomeGoalDetails,
                    Favorite.HOME_GOAL_KEEPER to data.strHomeLineupGoalkeeper,
                    Favorite.HOME_LINEUP_DEFENSE to data.strHomeLineupDefense,
                    Favorite.HOME_LINEUP_MIDFIELD to data.strHomeLineupMidfield,
                    Favorite.HOME_LINEUP_FORWARD to data.strHomeLineupForward,
                    Favorite.HOME_LINEUP_SUBSTITUTES to data.strHomeLineupSubstitutes,
                    Favorite.HOME_RED_CARDS to data.strHomeRedCards,
                    Favorite.HOME_YELLOW_CARDS to data.strHomeYellowCards,
                    Favorite.ID_HOME to data.idHomeTeam,
                    Favorite.AWAY_TEAM_NAME to data.strAwayTeam,
                    Favorite.AWAY_SCORE to data.intAwayScore,
                    Favorite.AWAY_GOAL_DETAILS to data.strAwayGoalDetails,
                    Favorite.AWAY_GOAL_KEEPER to data.strAwayLineupGoalkeeper,
                    Favorite.AWAY_LINEUP_DEFENSE to data.strAwayLineupDefense,
                    Favorite.AWAY_LINEUP_MIDFIELD to data.strAwayLineupMidfield,
                    Favorite.AWAY_LINEUP_FORWARD to data.strAwayLineupForward,
                    Favorite.AWAY_LINEUP_SUBSTITUTES to data.strAwayLineupSubstitutes,
                    Favorite.AWAY_RED_CARDS to data.strAwayRedCards,
                    Favorite.AWAY_YELLOW_CARDS to data.strAwayYellowCards,
                    Favorite.ID_AWAY to data.idAwayTeam
                )
            }
            mView?.showMessage("Added to Favorite")
        } catch (e: Throwable) {
            mView?.showMessage(e.localizedMessage)
        }
    }

    fun removeFromDB(id: String) {
        try {
            dbHelper.use {
                delete(
                    Favorite.TABLE_FAVORITE, "(EVENT_ID = {id})",
                    "id" to id
                )
            }
            mView?.showMessage("Removed from Favorite")
        } catch (e: SQLiteConstraintException) {
            mView?.showMessage(e.localizedMessage)
        }
    }

    fun checkIsFavorite(id: Long) {
        dbHelper.use {
            val result = select(Favorite.TABLE_FAVORITE)
                .whereArgs(
                    "(EVENT_ID = {id})",
                    "id" to id
                )
            val favorite = result.parseList(classParser<Favorite>())
            mView?.isFavorite(!favorite.isEmpty())
        }
    }
}