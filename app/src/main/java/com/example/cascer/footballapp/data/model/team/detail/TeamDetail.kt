package com.example.cascer.footballapp.data.model.team.detail

import com.google.gson.annotations.SerializedName

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
data class TeamDetail(

    @field:SerializedName("teams")
    val teamsItems: List<TeamDetailItem>? = null
)