package com.example.cascer.footballapp.ui.main.favorite

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cascer.footballapp.R
import com.example.cascer.footballapp.data.model.favorite.Favorite
import kotlinx.android.synthetic.main.item_match.view.*

/**
 *  Created by akhmad ghafirin on Nov 25, 2018.
 **/
class FavoriteAdapter(private var dataSet: MutableList<Favorite>, private val listener: (event: Favorite) -> Unit) :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                listener.invoke(dataSet[adapterPosition])
            }
        }

        fun bind(data: Favorite) {
            itemView.apply {
                tv_schedule.text = data.dateEvent
                tv_home.text = data.homeTeamName
                tv_away.text = data.awayTeamName
                tv_score_home.text = data.homeScore
                tv_score_away.text = data.awayScore
            }
        }
    }
}