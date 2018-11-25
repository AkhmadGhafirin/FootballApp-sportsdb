package com.example.cascer.footballapp.data.model.favorite

/**
 *  Created by akhmad ghafirin on Nov 22, 2018.
 **/
data class Favorite(
    val id: Long?, val eventId: Long?, val dateEvent: String?,
    val timeEvent: String?, val homeTeamName: String?, val homeScore: String?,
    val homeGoalDetails: String?, val homeGoalKeeper: String?, val homeLineupDefense: String?,
    val homeLineupMidField: String?, val homeLineupForward: String?, val homeLineupSubstitutes: String?,
    val homeRedCards: String?, val homeYellowCards: String?, val idHome: String?,
    val awayTeamName: String?, val awayScore: String?, val awayGoalDetails: String?,
    val awayGoalKeeper: String?, val awayLineupDefense: String?, val awayLineupMidField: String?,
    val awayLineupForward: String?, val awayLineupSubstitutes: String?, val awayRedCards: String?,
    val awayYellowCards: String?, val idAway: String?
) {

    companion object {
        const val TABLE_FAVORITE: String = "FAVORITE"
        const val ID: String = "ID"
        const val EVENT_ID = "EVENT_ID"
        const val EVENT_DATE = "EVENT_DATE"
        const val EVENT_TIME = "EVENT_TIME"
        const val HOME_TEAM_NAME = "HOME_TEAM_NAME"
        const val HOME_SCORE = "HOME_SCORE"
        const val HOME_GOAL_DETAILS = "HOME_GOAL_DETAILS"
        const val HOME_GOAL_KEEPER = "HOME_GOAL_KEEPER"
        const val HOME_LINEUP_DEFENSE = "HOME_LINEUP_DEFENSE"
        const val HOME_LINEUP_MIDFIELD = "HOME_LINEUP_MIDFIELD"
        const val HOME_LINEUP_FORWARD = "HOME_LINEUP_FORWARD"
        const val HOME_LINEUP_SUBSTITUTES = "HOME_LINEUP_SUBSTITUTES"
        const val HOME_RED_CARDS = "HOME_RED_CARDS"
        const val HOME_YELLOW_CARDS = "HOME_YELLOW_CARDS"
        const val ID_HOME = "ID_HOME"
        const val AWAY_TEAM_NAME = "AWAY_TEAM_NAME"
        const val AWAY_SCORE = "AWAY_SCORE"
        const val AWAY_GOAL_DETAILS = "AWAY_GOAL_DETAILS"
        const val AWAY_GOAL_KEEPER = "AWAY_GOAL_KEEPER"
        const val AWAY_LINEUP_DEFENSE = "AWAY_LINEUP_DEFENSE"
        const val AWAY_LINEUP_MIDFIELD = "AWAY_LINEUP_MIDFIELD"
        const val AWAY_LINEUP_FORWARD = "AWAY_LINEUP_FORWARD"
        const val AWAY_LINEUP_SUBSTITUTES = "AWAY_LINEUP_SUBSTITUTES"
        const val AWAY_RED_CARDS = "AWAY_RED_CARDS"
        const val AWAY_YELLOW_CARDS = "AWAY_YELLOW_CARDS"
        const val ID_AWAY = "ID_AWAY"
    }
}