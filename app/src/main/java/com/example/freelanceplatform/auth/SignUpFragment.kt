package com.example.freelanceplatform.auth

import android.content.Context
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
import com.example.freelanceplatform.model.Freelancer
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : Fragment(), AuthListener {
    private lateinit var binding: SignUpFragmentBinding
    private lateinit var email: String
    private lateinit var pass: String
    private lateinit var auth: FirebaseAuth

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: AuthViewModel
    var freelancer= Freelancer()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment, container, false)
        auth = FirebaseAuth.getInstance()
        /**
         * TODO: Handle Sign Up Button click
         *
         */


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this


    }

    override fun onStarted() {
        binding.progressbar.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        binding.progressbar.visibility = View.GONE
        val intent = Intent(
            context,
            MainActivity::class.java
        )
        startActivity(intent)
        isAuthenticated()
        isFirstTime()
    }

    override fun onFailure(message: String) {
        binding.progressbar.visibility = View.GONE
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()

    }
    private fun isAuthenticated() {
        val sharedPreference = context?.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var editor = sharedPreference?.edit()
        editor?.putBoolean("isAuthenticated", true)
        editor?.apply()

    }
    private fun isFirstTime() {
        val sharedPreference = context?.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var editor = sharedPreference?.edit()
        editor?.putBoolean("isFirstTime", false)
        editor?.apply()
    }

}
