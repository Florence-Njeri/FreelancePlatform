package com.example.freelanceplatform.repository

import com.example.freelanceplatform.model.FirebaseSource

/**
 *  The repository that will communicate with our Firebase backend
 */
class FreelancerRepository( private val firebase: FirebaseSource) {
    fun login(email: String, password: String) = firebase.login(email, password)

    fun register(email: String, password: String) = firebase.register(email, password)

    fun saveUserName(firstName: String, lastName: String) = firebase.saveFreelancerCredentials(firstName , lastName)

    fun currentUser() = firebase.currentUser()

    fun logout() = firebase.logout()
}