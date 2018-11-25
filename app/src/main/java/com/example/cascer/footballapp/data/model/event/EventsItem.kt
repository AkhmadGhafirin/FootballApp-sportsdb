package com.example.cascer.footballapp.data.model.event

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventsItem(

    @field:SerializedName("intHomeShots")
    val intHomeShots: String? = null,

    @field:SerializedName("strSport")
    val strSport: String? = null,

    @field:SerializedName("strHomeLineupDefense")
    var strHomeLineupDefense: String? = null,

    @field:SerializedName("strAwayLineupSubstitutes")
    var strAwayLineupSubstitutes: String? = null,

    @field:SerializedName("idLeague")
    val idLeague: String? = null,

    @field:SerializedName("idSoccerXML")
    val idSoccerXML: String? = null,

    @field:SerializedName("strHomeLineupForward")
    var strHomeLineupForward: String? = null,

    @field:SerializedName("strTVStation")
    val strTVStation: String? = null,

    @field:SerializedName("strHomeGoalDetails")
    var strHomeGoalDetails: String? = null,

    @field:SerializedName("strAwayLineupGoalkeeper")
    var strAwayLineupGoalkeeper: String? = null,

    @field:SerializedName("strAwayLineupMidfield")
    var strAwayLineupMidfield: String? = null,

    @field:SerializedName("idEvent")
    var idEvent: String = "null",

    @field:SerializedName("intRound")
    val intRound: String? = null,

    @field:SerializedName("strHomeYellowCards")
    var strHomeYellowCards: String? = null,

    @field:SerializedName("idHomeTeam")
    var idHomeTeam: String? = null,

    @field:SerializedName("intHomeScore")
    var intHomeScore: String? = null,

    @field:SerializedName("dateEvent")
    var dateEvent: String? = null,

    @field:SerializedName("strCountry")
    val strCountry: String? = null,

    @field:SerializedName("strAwayTeam")
    var strAwayTeam: String? = null,

    @field:SerializedName("strHomeLineupMidfield")
    var strHomeLineupMidfield: String? = null,

    @field:SerializedName("strDate")
    val strDate: String? = null,

    @field:SerializedName("strHomeFormation")
    val strHomeFormation: String? = null,

    @field:SerializedName("strMap")
    val strMap: String? = null,

    @field:SerializedName("idAwayTeam")
    var idAwayTeam: String? = null,

    @field:SerializedName("strAwayRedCards")
    var strAwayRedCards: String? = null,

    @field:SerializedName("strBanner")
    val strBanner: String? = null,

    @field:SerializedName("strFanart")
    val strFanart: String? = null,

    @field:SerializedName("strDescriptionEN")
    val strDescriptionEN: String? = null,

    @field:SerializedName("strResult")
    val strResult: String? = null,

    @field:SerializedName("strCircuit")
    val strCircuit: String? = null,

    @field:SerializedName("intAwayShots")
    val intAwayShots: String? = null,

    @field:SerializedName("strFilename")
    val strFilename: String? = null,

    @field:SerializedName("strTime")
    var strTime: String? = null,

    @field:SerializedName("strAwayGoalDetails")
    var strAwayGoalDetails: String? = null,

    @field:SerializedName("strAwayLineupForward")
    var strAwayLineupForward: String? = null,

    @field:SerializedName("strLocked")
    val strLocked: String? = null,

    @field:SerializedName("strSeason")
    val strSeason: String? = null,

    @field:SerializedName("intSpectators")
    val intSpectators: String? = null,

    @field:SerializedName("strHomeRedCards")
    var strHomeRedCards: String? = null,

    @field:SerializedName("strHomeLineupGoalkeeper")
    var strHomeLineupGoalkeeper: String? = null,

    @field:SerializedName("strHomeLineupSubstitutes")
    var strHomeLineupSubstitutes: String? = null,

    @field:SerializedName("strAwayFormation")
    val strAwayFormation: String? = null,

    @field:SerializedName("strEvent")
    val strEvent: String? = null,

    @field:SerializedName("strAwayYellowCards")
    var strAwayYellowCards: String? = null,

    @field:SerializedName("strAwayLineupDefense")
    var strAwayLineupDefense: String? = null,

    @field:SerializedName("strHomeTeam")
    var strHomeTeam: String? = null,

    @field:SerializedName("strThumb")
    val strThumb: String? = null,

    @field:SerializedName("strLeague")
    val strLeague: String? = null,

    @field:SerializedName("intAwayScore")
    var intAwayScore: String? = null,

    @field:SerializedName("strCity")
    val strCity: String? = null,

    @field:SerializedName("strPoster")
    val strPoster: String? = null
) : Parcelable