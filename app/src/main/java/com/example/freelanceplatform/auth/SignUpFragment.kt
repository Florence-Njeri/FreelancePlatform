package com.example.freelanceplatform.auth

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.freelanceplatform.MainActivity

import com.example.freelanceplatform.R
import com.example.freelanceplatform.databinding.SignUpFragmentBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : Fragment() {
    private lateinit var binding: SignUpFragmentBinding
    private lateinit var email: String
    private lateinit var pass: String
    private lateinit var auth: FirebaseAuth

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment, container, false)
        auth=FirebaseAuth.getInstance()
        /**
         * TODO: Handle Sign Up Button click
         *
         */
        binding.buttonSignUp.setOnClickListener {
            //TODO: Validate the input fields
            if (isInputValid()) {
                //Google Sign In
                auth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                context,
                                "Registration successful!",
                                Toast.LENGTH_LONG
                            ).show()
                            val intent = Intent(
                                context,
                                MainActivity::class.java
                            )
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                context,
                                "Failed to create user:\n ${task.exception?.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }


            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun isInputValid(): Boolean {
        email = binding.emailText.text.toString()
        pass = binding.passwordText.text.toString()
        val firstName = binding.firstName.text.toString()
        val lastName = binding.lastName.text.toString()
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
        if (TextUtils.isEmpty(firstName)) {
            isValid = false
            binding.firstName.requestFocus()
            binding.firstName.error = "First Name is Required"
        }
        if (TextUtils.isEmpty(lastName)) {
            isValid = false
            binding.lastName.requestFocus()
            binding.lastName.error = "Last Name is Required"
        }


        return isValid
    }


}
