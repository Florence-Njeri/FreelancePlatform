package com.example.freelanceplatform.auth

import android.content.Intent
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.freelanceplatform.MainActivity
import com.example.freelanceplatform.model.FirebaseSource
import com.example.freelanceplatform.model.Freelancer
import com.example.freelanceplatform.repository.FreelancerRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Will communicate with our FreelancerRepository when a user needs to log in
 */
class AuthViewModel() : ViewModel() {
    private val source = FirebaseSource()
    private val repository: FreelancerRepository = FreelancerRepository(source)
    //email and password input
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null


    //disposable to dispose the Completable
    private val disposables = CompositeDisposable()

    val user by lazy {
        repository.currentUser()
    }


    //Perform login
    fun loginWithGooogle() {
        //Validate email and password
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }
            //Authentication has started
            authListener?.onStarted()

            //Therefore call the repository to perform the authentication
            val disposable = repository.login(email!!, password!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    //Send success callback
                    authListener?.onSuccess()
                },
                    {
                        authListener?.onFailure(it.message!!)
                    })
            disposables.add(disposable)

    }

    fun signUpWithGoogle(){
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Please input all values")
            return
        }
        authListener?.onStarted()

        val disposable =repository.register(email!!,password!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                authListener?.onSuccess()
            }, {
                authListener?.onFailure(it.message!!)
            })
        disposables.add(disposable)

    }
    fun isValid(): Boolean {
        var isValid = true
        if (email.isNullOrEmpty()) {
            isValid = false
            authListener?.onFailure("Invalid email")
        }
        if (password.isNullOrEmpty()) {
            isValid = false
            authListener?.onFailure("Invalid password")
        }

        return isValid
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

}
