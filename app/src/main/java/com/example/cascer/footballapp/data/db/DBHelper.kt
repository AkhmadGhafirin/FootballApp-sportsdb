package com.example.cascer.footballapp.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import javax.inject.Inject

/**
 *  Created by akhmad ghafirin on Nov 22, 2018.
 **/
class DBHelper @Inject constructor(context: Context) : ManagedSQLiteOpenHelper(context, "Favorite.db", null, 2) {

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
            "FAVORITE", true,
            "ID" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            "EVENT_ID" to INTEGER + UNIQUE,
            "EVENT_DATE" to TEXT,
            "EVENT_TIME" to TEXT,
            "HOME_TEAM_NAME" to TEXT,
            "HOME_SCORE" to TEXT,
            "HOME_GOAL_DETAILS" to TEXT,
            "HOME_GOAL_KEEPER" to TEXT,
            "HOME_LINEUP_DEFENSE" to TEXT,
            "HOME_LINEUP_MIDFIELD" to TEXT,
            "HOME_LINEUP_FORWARD" to TEXT,
            "HOME_LINEUP_SUBSTITUTES" to TEXT,
            "HOME_RED_CARDS" to TEXT,
            "HOME_YELLOW_CARDS" to TEXT,
            "ID_HOME" to TEXT,
            "AWAY_TEAM_NAME" to TEXT,
            "AWAY_SCORE" to TEXT,
            "AWAY_GOAL_DETAILS" to TEXT,
            "AWAY_GOAL_KEEPER" to TEXT,
            "AWAY_LINEUP_DEFENSE" to TEXT,
            "AWAY_LINEUP_MIDFIELD" to TEXT,
            "AWAY_LINEUP_FORWARD" to TEXT,
            "AWAY_LINEUP_SUBSTITUTES" to TEXT,
            "AWAY_RED_CARDS" to TEXT,
            "AWAY_YELLOW_CARDS" to TEXT,
            "ID_AWAY" to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable("FAVORITE", true)
    }
}