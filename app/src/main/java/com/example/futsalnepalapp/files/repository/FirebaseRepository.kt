package com.example.futsalnepalapp.files.repository
import com.google.firebase.firestore.*
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.futsalnepalapp.files.util.MatchmakingRoom
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await



class FirebaseRepository() {

    private val matchmakingCollectionRef = Firebase.firestore.collection("matchmaking rooms")
    private val usersCollectionRef = Firebase.firestore.collection("Users")
    val matchesList = ArrayList<MatchmakingRoom>()
    val liveMatchesList = MutableLiveData<ArrayList<MatchmakingRoom>>()


    suspend fun upsert(item: MatchmakingRoom) {
            matchmakingCollectionRef.add(item).await()
    }

    suspend fun delete(item: MatchmakingRoom) {

    }
}