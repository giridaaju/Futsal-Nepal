package com.example.futsalnepalapp.files.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.futsalnepalapp.R
import com.example.futsalnepalapp.files.ui.RegisterUserActivity
import com.example.futsalnepalapp.files.ui.SignInActivity
import com.example.futsalnepalapp.files.util.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    val auth = FirebaseAuth.getInstance()
    val user = auth.currentUser
    val usersRef = Firebase.firestore.collection("Users")
    val userID = user?.uid
    var currentUser = User("", "", "", "")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (checkLoggedInState()) {
            profileLayout.visibility = View.VISIBLE
            noAccountLayoutP.visibility = View.GONE
            updateUserProfile()
        }
        else if (!checkLoggedInState()){
            profileLayout.visibility = View.GONE
            noAccountLayoutP.visibility = View.VISIBLE
        }

        btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            profileLayout.visibility = View.GONE
            noAccountLayoutP.visibility = View.VISIBLE
        }

        tvProfileSignIn.setOnClickListener {
            startActivity(Intent(requireActivity(), SignInActivity::class.java))
        }

        tvProfileRegister.setOnClickListener {
            startActivity(Intent(requireActivity(), RegisterUserActivity::class.java))
        }
    }

    //Can be stored in shared pref class. API will be only called once during fragment creation. Further uses of userID
    //will be used directly from the shared pref class, Only one API call per use of app as opposed to every fragment refresh.
    //Will save on API call cost.
    fun updateUserProfile() = CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot = usersRef.whereEqualTo("uid", userID).get().await()
            for (document in querySnapshot.documents) {
                currentUser = document.toObject<User>()!!
                Log.d("PROFILE", document.data.toString())
            }
            withContext(Dispatchers.Main) {
                tvUserName.text = currentUser.fullName
                tvUserEmail.text = currentUser.email
                tvUserPhoneNumber.text = currentUser.phoneNumber
            }
        }
        catch (e: Exception) {
            Log.d("PROFILE", e.message.toString())
        }
    }

    private fun checkLoggedInState(): Boolean {
        return auth.currentUser != null
    }
}