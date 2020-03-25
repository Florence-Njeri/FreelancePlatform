package com.example.freelanceplatform.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.freelanceplatform.MainActivity
import com.example.freelanceplatform.R
import com.example.freelanceplatform.databinding.LogInFragmentBinding
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.internal.operators.maybe.MaybeToPublisher.instance
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class LogInActivity(override val kodein: Kodein) : AppCompatActivity(),AuthListener, KodeinAware {
    private lateinit var binding: LogInFragmentBinding
    private lateinit var email: String
    private lateinit var pass: String
    private lateinit var auth: FirebaseAuth
    private lateinit var viewModel: AuthViewModel
    private val factory : AuthViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.log_in_fragment)
        viewModel=ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        binding.viewmodel=viewModel
        auth = FirebaseAuth.getInstance()

        viewModel.authListener=this
        binding.logInButton.setOnClickListener {
            //LogIn
            viewModel.login()

        }

    }

    override fun onStarted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess() {
        startActivity(
            Intent(
                this,
                MainActivity::class.java
            )
        )    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()    }
}
