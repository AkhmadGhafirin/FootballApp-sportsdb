package com.example.cascer.footballapp.data.model.team.list

import com.google.gson.annotations.SerializedName

data class TeamList(

	@field:SerializedName("teams")
	val teams: List<TeamsItem>? = null
)