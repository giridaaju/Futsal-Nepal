package com.example.futsalnepalapp.files.ui.dialogs

import com.example.futsalnepalapp.files.util.MatchmakingRoom
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

interface AddMatchmakingDialogListener {

    //abstract fun onCreateMatchButtonClicked(item: MatchmakingRoom)

}