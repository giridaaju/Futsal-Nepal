package com.example.futsalnepalapp.files.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.futsalnepalapp.files.repository.FirebaseRepository
import com.example.futsalnepalapp.files.util.MatchmakingRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MatchmakingViewModel (private val firebaseRepository: FirebaseRepository) : ViewModel() {

    fun upsert(item: MatchmakingRoom) =  viewModelScope.launch(Dispatchers.IO) {
        firebaseRepository.upsert(item)
    }

    fun delete(item: MatchmakingRoom) = viewModelScope.launch(Dispatchers.IO) {
        firebaseRepository.delete(item)
    }

}