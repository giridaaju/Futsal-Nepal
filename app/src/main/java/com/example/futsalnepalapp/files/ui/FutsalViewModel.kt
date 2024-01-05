package com.example.futsalnepalapp.files.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.futsalnepalapp.files.repository.FutsalRepository
import com.example.futsalnepalapp.files.util.Futsal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FutsalViewModel(val futsalRepository: FutsalRepository) : ViewModel() {

    fun upsert(item: Futsal) = viewModelScope.launch(Dispatchers.IO) {
        futsalRepository.upsert(item)
    }

    fun delete(item: Futsal) = viewModelScope.launch(Dispatchers.IO) {
        futsalRepository.delete(item)
    }

    fun getAllFutsals() = futsalRepository.getAllFutsals()

    fun getFutsalNames() = futsalRepository.getFutsalNames()

    fun initialUpsert() = viewModelScope.launch(Dispatchers.IO) {
        futsalRepository.initialUpsert()
    }

    fun searchFutsals(searchQuery: String) = futsalRepository.searchFutsals(searchQuery)

}