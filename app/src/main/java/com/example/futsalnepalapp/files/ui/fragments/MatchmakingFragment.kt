package com.example.futsalnepalapp.files.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.futsalnepalapp.R
import com.example.futsalnepalapp.files.adapters.MatchmakingRoomAdapter
import com.example.futsalnepalapp.files.adapters.MatchmakingRoomClickListener
import com.example.futsalnepalapp.files.ui.RegisterUserActivity
import com.example.futsalnepalapp.files.ui.SignInActivity
import com.example.futsalnepalapp.files.ui.dialogs.AddMatchmakingRoomDialog
import com.example.futsalnepalapp.files.util.MatchmakingRoom
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_matchmaking.*
import kotlinx.android.synthetic.main.fragment_matchmaking.noAccountLayoutM
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception

class MatchmakingFragment : Fragment(R.layout.fragment_matchmaking), MatchmakingRoomClickListener {

    var auth = FirebaseAuth.getInstance()
    lateinit var matchmakingAdapter: MatchmakingRoomAdapter
    var matchmakingCollectionRef = Firebase.firestore.collection("matchmaking rooms")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (checkLoggedInState()) {
            matchmakingLayout.visibility = View.VISIBLE
            noAccountLayoutM.visibility = View.GONE
        }
        else if (!checkLoggedInState()){
            matchmakingLayout.visibility = View.GONE
            noAccountLayoutM.visibility = View.VISIBLE
        }

        tvMatchmakingSignIn.setOnClickListener {
            startActivity(Intent(requireActivity(), SignInActivity::class.java))
        }

        tvMatchmakingRegister.setOnClickListener {
            startActivity(Intent(requireActivity(), RegisterUserActivity::class.java))
        }

        matchmakingAdapter = MatchmakingRoomAdapter(mutableListOf(), this)

        btnFab.setOnClickListener{
            AddMatchmakingRoomDialog(requireContext()).show()
        }

        rvMatchmakingRooms.adapter = matchmakingAdapter
        rvMatchmakingRooms.layoutManager = LinearLayoutManager(activity)
        getAllMatches()
    }

    override fun onItemClick(matchmakingRoom: MatchmakingRoom) {
        val matchmakingRoomFragment = MatchmakingRoomFragment.newInstance(
            matchmakingRoom.futsal,
            matchmakingRoom.totalPlayers,
            matchmakingRoom.requiredPlayers,
            matchmakingRoom.matchDate,
            matchmakingRoom.matchTime,
            matchmakingRoom.additionalInfo,
            matchmakingRoom.createdBy
        )
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.flFragment, matchmakingRoomFragment, "matchmaking_room_fragment")
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

    fun getAllMatches() = CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot = matchmakingCollectionRef.get().await()
            val matches : MutableList<MatchmakingRoom> = mutableListOf()
            for (document in querySnapshot.documents) {
                val match = document.toObject<MatchmakingRoom>()
                if (match != null) {
                    matches.add(match)
                }
            }
            Log.d("FIRESTORE", "Matches have been retrieved")
            withContext(Dispatchers.Main) {
                matchmakingAdapter.matches = matches
                matchmakingAdapter.notifyDataSetChanged()
            }
        }
        catch (e: Exception) {
            Log.d("FIRESTORE", e.message.toString())
        }
    }

    private fun checkLoggedInState(): Boolean {
        return auth.currentUser != null
    }

}
