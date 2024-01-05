package com.example.futsalnepalapp.files.repository

import com.example.futsalnepalapp.files.database.FutsalDatabase
import com.example.futsalnepalapp.files.util.Futsal

class FutsalRepository(val db: FutsalDatabase) {

    suspend fun upsert(item: Futsal) = db.getFutsalDao().upsert(item)

    suspend fun delete(item: Futsal) = db.getFutsalDao().delete(item)

    fun getAllFutsals() = db.getFutsalDao().getAllFutsals()

    fun getFutsalNames() = db.getFutsalDao().getFutsalNames()

    suspend fun initialUpsert() = db.getFutsalDao().initialUpsert()

    fun searchFutsals(searchQuery: String) = db.getFutsalDao().searchFutsals(searchQuery)

}