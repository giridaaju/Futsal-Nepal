package com.example.futsalnepalapp.files.util

data class User (
    val uid : String,
    val fullName : String,
    val email: String,
    val phoneNumber: String,
        ) {
    constructor() : this("", "", "", "")
}