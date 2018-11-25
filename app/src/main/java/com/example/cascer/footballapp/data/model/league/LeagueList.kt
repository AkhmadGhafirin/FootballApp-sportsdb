package com.example.cascer.footballapp.data.model.league

import com.google.gson.annotations.SerializedName

data class LeagueList(

	@field:SerializedName("leagues")
	val leagues: List<LeaguesItem?>? = null
)