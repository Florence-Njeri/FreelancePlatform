package com.example.freelanceplatform.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.freelanceplatform.repository.FreelancerRepository

class AuthViewModelFactory(private val repository: FreelancerRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AuthViewModel(repository)as T

    }

}