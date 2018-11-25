package com.example.cascer.footballapp.ui.main.team

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cascer.footballapp.R
import com.example.cascer.footballapp.app.GlideApp
import com.example.cascer.footballapp.data.model.favorite.Favorite
import com.example.cascer.footballapp.data.model.team.list.TeamsItem
import kotlinx.android.synthetic.main.item_team.view.*

class TeamAdapter(private var dataSet: MutableList<TeamsItem>, private val listener: (team: TeamsItem) -> Unit) :
    RecyclerView.Adapter<TeamAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
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

        fun bind(data: TeamsItem) {
            itemView.apply {
                tv_team.text = data.strTeam
                GlideApp.with(context).load(data.strTeamBadge).into(iv_team)
            }
        }
    }
}