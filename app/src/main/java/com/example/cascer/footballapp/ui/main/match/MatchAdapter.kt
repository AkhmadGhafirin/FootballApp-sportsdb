package com.example.cascer.footballapp.ui.main.match

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cascer.footballapp.R
import com.example.cascer.footballapp.data.model.event.EventsItem
import kotlinx.android.synthetic.main.item_match.view.*

/**
 *  Created by akhmad ghafirin on Nov 13, 2018.
 **/
class MatchAdapter(private var dataSet: MutableList<EventsItem>, private val listener: (event: EventsItem) -> Unit) :
    RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

    fun updateList(list: List<EventsItem>) {
        if (list.size != dataSet.size || !dataSet.containsAll(list)) {
            dataSet.addAll(list)
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                listener.invoke(dataSet[adapterPosition])
            }
        }

        fun bind(data: EventsItem) {
            itemView.apply {
                tv_schedule.text = data.dateEvent
                tv_home.text = data.strHomeTeam
                tv_away.text = data.strAwayTeam
                tv_score_home.text = data.intHomeScore
                tv_score_away.text = data.intAwayScore
            }
        }
    }
}