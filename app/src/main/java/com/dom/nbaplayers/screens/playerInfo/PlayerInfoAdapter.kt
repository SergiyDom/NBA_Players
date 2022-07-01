package com.dom.nbaplayers.screens.playerInfo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dom.nbaplayers.R
import com.dom.nbaplayers.model.allPlayers.Data
import kotlinx.android.synthetic.main.player_layout.view.*

class PlayerInfoAdapter : RecyclerView.Adapter<PlayerInfoAdapter.PlayerInfoViewHolder>() {

    var listAllPlayers = emptyList<Data>()

    class PlayerInfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.player_layout, parent, false)
        return PlayerInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerInfoViewHolder, position: Int) {
        holder.itemView.tv_first_name.text = listAllPlayers[position].first_name
        holder.itemView.tv_last_name.text = listAllPlayers[position].last_name
        holder.itemView.tv_position.text = listAllPlayers[position].position
        holder.itemView.tv_height.text = listAllPlayers[position].height_feet.toString()
        holder.itemView.tv_weight.text = listAllPlayers[position].weight_pounds.toString()
        holder.itemView.tv_team.text = listAllPlayers[position].team.toString()
    }

    override fun getItemCount(): Int {
        return listAllPlayers.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Data>) {
        listAllPlayers = list
        notifyDataSetChanged()
    }
}