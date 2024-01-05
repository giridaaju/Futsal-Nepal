package com.example.futsalnepalapp.files.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.futsalnepalapp.R
import com.example.futsalnepalapp.files.util.MatchmakingRoom
import kotlinx.android.synthetic.main.item_matchmaking_room.view.*

class MatchmakingRoomAdapter(var matches: MutableList<MatchmakingRoom>, itemClickListener : MatchmakingRoomClickListener) : RecyclerView.Adapter<MatchmakingRoomAdapter.MatchmakingViewHolder>() {

    private val clickListener = itemClickListener

    inner class MatchmakingViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchmakingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_matchmaking_room,
            parent,
            false
        )
        return MatchmakingViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchmakingRoomAdapter.MatchmakingViewHolder, position: Int) {
        holder.itemView.apply {
            tvMatchmakingFutsalName.text = matches[position].futsal
            tvMatchmakingCreatedBy.text = "Created by: " + matches[position].createdBy
            tvMatchmakingDate.text = matches[position].matchDate
            tvMatchmakingTime.text = matches[position].matchTime
            val currentPlayers = matches[position].totalPlayers - matches[position].requiredPlayers
            tvMatchmakingPlayersCount.text = currentPlayers.toString() + "/" + matches[position].totalPlayers.toString()
        }

        holder.itemView.setOnClickListener{
            clickListener.onItemClick(matches[position])
        }
    }

    override fun getItemCount(): Int {
        return matches.size
    }


}