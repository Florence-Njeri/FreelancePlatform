package com.example.freelanceplatform.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.constraintlayout.widget.Constraints
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.freelanceplatform.MainActivity
import com.example.freelanceplatform.R
import com.example.freelanceplatform.databinding.LogInFragmentBinding
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: LogInFragmentBinding
    private lateinit var email: String
    private lateinit var pass: String
    private lateinit var auth: FirebaseAuth
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.log_in_fragment)
        viewModel= ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel=viewModel
        auth = FirebaseAuth.getInstance()

        binding.logInButton.setOnClickListener {
            if (isInputValid()) {
                auth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(Constraints.TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            startActivity(
                                Intent(
                                    this,
                                    MainActivity::class.java
                                )
                            )
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(Constraints.TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(
                                this, "Authentication failed: ${task.exception?.message}",
                                Toast.LENGTH_SHORT
                            ).show()

                        }

                    }

            }


        }

    }
    fun isInputValid(): Boolean {
        email = binding.emailText.text.toString()
        pass = binding.passwordText.text.toString()

//TODO find out why isValid is always false
        var isValid = true
        if (TextUtils.isEmpty(email)) {
            isValid = false
            binding.emailText.requestFocus()
            binding.emailText.error = "Email is required"
        }
        if (TextUtils.isEmpty(pass)) {
            isValid = false
            binding.passwordText.requestFocus()
            binding.passwordText.error = "Password is Required"
        }

        return isValid
    }
}
