package com.example.futsalnepalapp.files.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.futsalnepalapp.R
import com.example.futsalnepalapp.files.util.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var currentUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth = FirebaseAuth.getInstance()

        tvProfileRegister.setOnClickListener {
            startActivity(Intent(this, RegisterUserActivity::class.java))
        }

        btnSignIn.setOnClickListener {
            userLogin()
        }
    }

    fun userLogin() {
        val email = etSignInEmail.text.toString().trim()
        val password = etSignInPassword.text.toString().trim()

        if (email.isEmpty()) {
            etSignInEmail.error = "Email is required"
            etSignInEmail.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etSignInEmail.error = "Please enter a valid email"
            etSignInEmail.requestFocus()
            return
        }

        if (password.isEmpty()) {
            etSignInPassword.error = "Password is required"
            etSignInPassword.requestFocus()
            return
        }

        pbSignIn.visibility = View.VISIBLE

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        pbSignIn.visibility = View.GONE
                        startActivity(Intent(this@SignInActivity, FutsalActivity::class.java))
                    } else {
                        pbSignIn.visibility = View.GONE
                        Toast.makeText(this@SignInActivity, "Failed to login! Please check your credentials", Toast.LENGTH_LONG).show()
                    }
                }
            }
}