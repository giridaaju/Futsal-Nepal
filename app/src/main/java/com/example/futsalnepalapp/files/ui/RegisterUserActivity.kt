package com.example.futsalnepalapp.files.ui

import android.app.AuthenticationRequiredException
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.futsalnepalapp.R
import com.example.futsalnepalapp.files.util.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register_user.*
import kotlinx.coroutines.launch


class RegisterUserActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    private var registerUserRef = Firebase.firestore.collection("Users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        auth = FirebaseAuth.getInstance()

        btnRegisterUser.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val fullName = etRegisterFullName.text.toString().trim()
        val email = etRegisterEmail.text.toString().trim()
        val phoneNumber = etRegisterPhone.text.toString().trim()
        val password = etRegisterPassword.text.toString().trim()
        val confirmPassword = etRegisterConfirmPassword.text.toString().trim()

        if (fullName.isEmpty()) {
            etRegisterFullName.error = "Full name is required"
            etRegisterFullName.requestFocus()
            return
        }

        if (email.isEmpty()) {
            etRegisterEmail.error = "Email address is required"
            etRegisterEmail.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etRegisterEmail.error = "Email address is not valid"
            etRegisterEmail.requestFocus()
            return
        }

        if (phoneNumber.isEmpty()) {
            etRegisterPhone.error = "Phone number is required"
            etRegisterPhone.requestFocus()
            return
        }

        if (phoneNumber.length != 10) {
            etRegisterPhone.error = "Please enter a valid phone number"
            etRegisterPhone.requestFocus()
            return
        }

        if (password.isEmpty()) {
            etRegisterPassword.error = "Password is required"
            etRegisterPassword.requestFocus()
            return
        }

        if (password.length < 6) {
            etRegisterPassword.error = "Password should be at least 6 characters"
            etRegisterPassword.requestFocus()
            return
        }

        if (confirmPassword.isEmpty()) {
            etRegisterConfirmPassword.error = "Password is required"
            etRegisterConfirmPassword.requestFocus()
            return
        }

        if (password != confirmPassword) {
            etRegisterConfirmPassword.error = "Passwords do not match"
            etRegisterConfirmPassword.requestFocus()
            return
        }

        pbRegisterUser.visibility = View.VISIBLE
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val newUser = User(uid = task.result.user!!.uid, fullName, email, phoneNumber)
                    lifecycleScope.launch {
                        registerUserRef.add(newUser)
                    }.invokeOnCompletion {
                        pbRegisterUser.visibility = View.GONE
                        Log.d("REGISTER", "Registration has been successful")
                        Toast.makeText(this, "Account has been succesfully created", Toast.LENGTH_LONG)
                        auth.signOut()
                        startActivity(Intent(this, SignInActivity::class.java))
                        finish()
                    }
                }
                else {
                    pbRegisterUser.visibility = View.GONE
                    Log.d("REGISTER", task.exception.toString())
                    Toast.makeText(this, "Account registration failed, Please try again", Toast.LENGTH_LONG)
                }
            }
    }
}

