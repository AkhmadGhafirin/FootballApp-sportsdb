package com.example.cascer.footballapp.data.network

import com.example.cascer.footballapp.data.model.event.EventList
import com.example.cascer.footballapp.data.model.team.TeamList
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
interface Api {

    @GET("api/v1/json/1/eventspastleague.php?id=4328")
    fun getLastEvent(): Single<EventList>

    @GET("api/v1/json/1/eventsnextleague.php?id=4328")
    fun getNextEvent(): Single<EventList>

    @GET("api/v1/json/1/lookupteam.php")
    fun getTeamDetail(@Query("id") id: String?): Single<TeamList>
}