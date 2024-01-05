package com.example.futsalnepalapp.files.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.futsalnepalapp.files.repository.FutsalRepository

class FutsalViewModelProviderFactory(
    val futsalRepository: FutsalRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FutsalViewModel(futsalRepository) as T
    }

}