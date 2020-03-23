package com.example.freelanceplatform.auth

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.Constraints.TAG
import androidx.databinding.DataBindingUtil
import com.example.freelanceplatform.MainActivity

import com.example.freelanceplatform.R
import com.example.freelanceplatform.databinding.LogInFragmentBinding
import com.google.firebase.auth.FirebaseAuth

class LogInFragment : Fragment() {
    private lateinit var binding: LogInFragmentBinding
    private lateinit var auth: FirebaseAuth

    companion object {
        fun newInstance() = LogInFragment()
    }

    private lateinit var viewModel: LogInViewModel
    private lateinit var email: String
    private lateinit var pass: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.log_in_fragment, container, false)
        auth = FirebaseAuth.getInstance()

        binding.logInButton.setOnClickListener {
            if (isInputValid()) {
                auth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            startActivity(
                                Intent(
                                    context,
                                    MainActivity::class.java
                                )
                            )
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(
                                context, "Authentication failed: ${task.exception?.message}",
                                Toast.LENGTH_SHORT
                            ).show()

                        }

                    }

            }


        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LogInViewModel::class.java)
        // TODO: Use the ViewModel
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
