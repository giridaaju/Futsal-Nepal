package com.example.futsalnepalapp.files.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.futsalnepalapp.files.repository.FirebaseRepository

class MatchmakingViewModelProviderFactory(
    val firebaseRepository: FirebaseRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MatchmakingViewModel(firebaseRepository) as T
    }
}