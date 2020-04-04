package com.example.freelanceplatform.ui.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.freelanceplatform.model.ActiveProjects

/**
 * A factory method to instantiate the ViewModel.
 */
class DetailsViewModelFactory(private val projectProperty: ActiveProjects,
                              private val application: Application
) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProjectDetailsViewModel::class.java)) {
            return ProjectDetailsViewModel(projectProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }    }

