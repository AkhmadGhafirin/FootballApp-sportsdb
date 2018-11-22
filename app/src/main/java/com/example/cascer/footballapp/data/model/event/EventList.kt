package com.example.cascer.footballapp.data.model.event

import com.google.gson.annotations.SerializedName

data class EventList(

	@field:SerializedName("events")
	val events: List<EventsItem>? = null
)