package com.example.freelanceplatform.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.freelanceplatform.model.FirebaseSource
import com.example.freelanceplatform.model.Freelancer
import com.example.freelanceplatform.repository.FreelancerRepository
import com.google.firebase.firestore.auth.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
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
    var firstName: String? = null
    var lastName: String? = null

    var authListener: AuthListener? = null

    var freelancer=Freelancer()


    //disposable to dispose the Completable
    private val disposables = CompositeDisposable()

    val user by lazy {
        repository.currentUser()
    }


    //Perform login
    fun loginWithGoogle() {
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
                    freelancer.isAuthenticated=true

                },
                    {
                        authListener?.onFailure(it.message!!)
                    })
            disposables.add(disposable)

    }

    fun signUpWithGoogle(){
        if (email.isNullOrEmpty() || password.isNullOrEmpty() || firstName.isNullOrEmpty() || lastName.isNullOrEmpty()) {
            authListener?.onFailure("Please input all values")
            return
        }
        authListener?.onStarted()

        val disposable =repository.register(email!!,password!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                authListener?.onSuccess()
                repository.saveUserName(firstName!!, lastName!!)
                freelancer.isAuthenticated=true
                freelancer.isCreated=true
            }, {
                authListener?.onFailure(it.message!!)
            })
        disposables.add(disposable)

    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

}
