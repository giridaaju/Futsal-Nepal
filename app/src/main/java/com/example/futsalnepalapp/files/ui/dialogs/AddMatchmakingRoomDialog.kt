package com.example.futsalnepalapp.files.ui.dialogs

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.futsalnepalapp.R
import com.example.futsalnepalapp.files.ui.FutsalActivity
import com.example.futsalnepalapp.files.ui.FutsalViewModel
import com.example.futsalnepalapp.files.ui.FutsalViewModelProviderFactory
import com.example.futsalnepalapp.files.util.MatchmakingRoom
import com.example.futsalnepalapp.files.util.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.dialog_create_matchmaking_room.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import okhttp3.internal.notify
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class AddMatchmakingRoomDialog(context: Context): AppCompatDialog(context) { //add dialog listener var

    private val matchmakingCollectionRef = Firebase.firestore.collection("matchmaking rooms")
    private val auth = FirebaseAuth.getInstance()
    private val user = auth.currentUser
    private val usersRef = Firebase.firestore.collection("Users")
    private val userID = user?.uid
    var currentUser = User("", "", "", "")
    var createdBy : String = ""
    var hostUID : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_create_matchmaking_room)

        btnDialogAddTotalPlayers.setOnClickListener {
            var playerAmount = tvDialogTotalPlayersAmount.text.toString().toInt()
            playerAmount++
            tvDialogTotalPlayersAmount.text = playerAmount.toString()
        }

        btnDialogSubtractTotalPlayers.setOnClickListener {
            var playerAmount = tvDialogTotalPlayersAmount.text.toString().toInt()
            if(playerAmount > -1) {
                playerAmount--
                tvDialogTotalPlayersAmount.text = playerAmount.toString()
            }
        }

        btnDialogAddPlayersNeeded.setOnClickListener {
            var requiredPlayers = tvDialogRequiredPlayersAmount.text.toString().toInt()
            requiredPlayers++
            tvDialogRequiredPlayersAmount.text = requiredPlayers.toString()
        }

        btnDialogSubtractPlayersNeeded.setOnClickListener {
            var requiredPlayers = tvDialogRequiredPlayersAmount.text.toString().toInt()
            if(requiredPlayers > -1) {
                requiredPlayers--
                tvDialogRequiredPlayersAmount.text = requiredPlayers.toString()
            }
        }

        fetchCreatedBy()

        btnDialogCreateMatchmakingRoom.setOnClickListener {
            val totalPlayers = tvDialogTotalPlayersAmount.text.toString().toInt()
            val requiredPlayers = tvDialogRequiredPlayersAmount.text.toString().toInt()
            val futsal = spDialogFutsalNames.selectedItem.toString()
            val matchDate = etDialogDate.text.toString()
            val matchTime = etDialogTime.text.toString()
            val isWinnersPay = cbDialogIsWinnersPay.isChecked
            val additionalInfo = etDialogAdditionalInfo.text.toString()

            if (totalPlayers == 0 || requiredPlayers == 0 || matchDate.isEmpty() || matchTime.isEmpty() || futsal.isEmpty()) {
                Toast.makeText(context, "Required fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else {
                val newMatch = MatchmakingRoom(futsal, createdBy, hostUID, totalPlayers, requiredPlayers, matchDate, matchTime, isWinnersPay, additionalInfo)
                Toast.makeText(context, "New match created", Toast.LENGTH_SHORT).show()
                saveMatch(newMatch)
                dismiss()
            }
        }

        btnDialogCancelMatchmakingRoom.setOnClickListener {
            cancel()
        }
    }

    fun saveMatch(newMatch: MatchmakingRoom) = CoroutineScope(Dispatchers.IO).launch {
        try {
            matchmakingCollectionRef.add(newMatch).await()
        }
        catch (e: Exception) {
            e.message?.let { Log.d("FIRE", it) }
        }
    }

    fun fetchCreatedBy() = CoroutineScope(Dispatchers.IO).launch {
            try {
                val querySnapshot = usersRef.whereEqualTo("uid", userID).get().await()
                for (document in querySnapshot.documents) {
                    currentUser = document.toObject<User>()!!
                    Log.d("PROFILE", document.data.toString())
                }
                withContext(Dispatchers.Main) {
                    createdBy = currentUser.fullName
                    hostUID = currentUser.uid
                }
            }
            catch (e: Exception) {
                Log.d("PROFILE", e.message.toString())
            }
        }
    }
