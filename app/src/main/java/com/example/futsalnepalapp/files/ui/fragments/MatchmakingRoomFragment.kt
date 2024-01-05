package com.example.futsalnepalapp.files.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.futsalnepalapp.R
import kotlinx.android.synthetic.main.fragment_matchmaking_room.*
import kotlin.concurrent.fixedRateTimer

class MatchmakingRoomFragment : Fragment(R.layout.fragment_matchmaking_room) {

    private val NAME = "name"
    private val TOTAL_PLAYERS = "total players"
    private val REQUIRED_PLAYERS = "required players"
    private val DATE = "date"
    private val TIME = "time"
    private val ADDITIONAL_INFO = "additional info"
    private val HOST_NAME = "created by"

    private var m_name = "name"
    private var m_total_players = 0
    private var m_required_players = 0
    private var m_date = "date"
    private var m_time = "time"
    private var m_additional_info = "additional info"
    private var m_host_name = "created by"

    companion object {
        fun newInstance(
            name: String,
            totalPlayers: Int,
            requiredPlayers: Int,
            date: String,
            time: String,
            additionalInfo: String,
            createdBy: String
        ) = MatchmakingRoomFragment().apply {
            arguments = bundleOf(
                NAME to name,
                TOTAL_PLAYERS to totalPlayers,
                REQUIRED_PLAYERS to requiredPlayers,
                DATE to date,
                TIME to time,
                ADDITIONAL_INFO to additionalInfo,
                HOST_NAME to createdBy
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            m_name = arguments?.getString(NAME).toString()
            m_total_players = arguments?.getInt(TOTAL_PLAYERS)!!
            m_required_players = arguments?.getInt(REQUIRED_PLAYERS)!!
            m_date = arguments?.getString(DATE).toString()
            m_time = arguments?.getString(TIME).toString()
            m_additional_info = arguments?.getString(ADDITIONAL_INFO).toString()
            m_host_name = arguments?.getString(HOST_NAME).toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvRoomFutsalName.text = m_name

        val currentPlayers = m_total_players - m_required_players
        tvRoomPlayerCount.text = currentPlayers.toString() + "/" + m_total_players.toString()

        tvRoomMatchDate.text = "Date: " + m_date
        tvRoomMatchTime.text = "Time: " + m_time
        tvAdditionalInfo.text = "Additional Info: " + m_additional_info
        tvHostName.text = m_host_name

        btnBackToMatchmaking.setOnClickListener {
            fragmentManager?.popBackStackImmediate()
        }



    }
}