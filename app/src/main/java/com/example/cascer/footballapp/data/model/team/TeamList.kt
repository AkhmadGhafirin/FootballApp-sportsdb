package com.example.cascer.footballapp.data.model.team

import com.google.gson.annotations.SerializedName

/**
 *  Created by akhmad ghafirin on Nov 11, 2018.
 **/
data class TeamList(

    @field:SerializedName("teams")
    val teamsItems: List<TeamsItem>? = null
)