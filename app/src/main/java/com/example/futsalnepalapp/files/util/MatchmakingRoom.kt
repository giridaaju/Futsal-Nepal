package com.example.futsalnepalapp.files.util

data class MatchmakingRoom (
    val futsal: String = "", //change to futsal later
    val createdBy : String = "",
    val hostUID : String = "",
    val totalPlayers: Int = 0,
    val requiredPlayers: Int = 0,
    val matchDate: String = "",
    val matchTime: String = "",
    val winnersPay: Boolean = false,
    val additionalInfo: String = ""
        )
