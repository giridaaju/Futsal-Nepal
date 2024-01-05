package com.example.futsalnepalapp.files.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.futsalnepalapp.R
import com.example.futsalnepalapp.files.database.FutsalDatabase
import com.example.futsalnepalapp.files.repository.FutsalRepository
import com.example.futsalnepalapp.files.repository.FirebaseRepository
import kotlinx.android.synthetic.main.activity_futsal.*


class FutsalActivity : AppCompatActivity() {

    lateinit var futsalViewModel: FutsalViewModel
    lateinit var matchmakingViewModel: MatchmakingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_futsal)

        val futsalRepository = FutsalRepository(FutsalDatabase(this))
        val viewModelProviderFactory = FutsalViewModelProviderFactory(futsalRepository)
        futsalViewModel = ViewModelProvider(this, viewModelProviderFactory)[FutsalViewModel::class.java]

        val matchmakingRepository = FirebaseRepository()
        val matchmakingViewModelProviderFactory = MatchmakingViewModelProviderFactory(matchmakingRepository)
        matchmakingViewModel = ViewModelProvider(this, matchmakingViewModelProviderFactory)[MatchmakingViewModel::class.java]

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.futsalNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
    }
}