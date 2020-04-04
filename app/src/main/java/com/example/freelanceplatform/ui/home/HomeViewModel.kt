package com.example.freelanceplatform.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.freelanceplatform.model.ActiveProjects
import com.example.freelanceplatform.model.FirebaseSource
import com.example.freelanceplatform.repository.FreelancerRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class HomeViewModel : ViewModel() {
    private val source = FirebaseSource()
    private val repository: FreelancerRepository = FreelancerRepository(source)

    //disposable to dispose the Completable
    private val disposables = CompositeDisposable()
    var firestoreListener: FirestoreListener? = null
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    //LiveData for navigation
    private val _navigateToProjectDetails = MutableLiveData<ActiveProjects>()
    val navigateToProjectDetails: LiveData<ActiveProjects>
        get() = _navigateToProjectDetails

    val text: LiveData<String> = _text
    private var projectsList = mutableListOf<ActiveProjects>()
    //RecyclerView data
    private val _activeProjectsList = MutableLiveData<List<ActiveProjects>>()
    val activeProjectsList: LiveData<List<ActiveProjects>> = _activeProjectsList

    private val firebaseFirestore: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }

    init {
        getActiveProjects()
    }

    fun getActiveProjects() {
        firebaseFirestore.collection("freelancer")
            .limit(25)
            .get()
            .addOnSuccessListener { result ->

                projectsList.clear()
                        for (document in result) {
                            val hitters = document.toObject(ActiveProjects::class.java)
                            projectsList.addAll(listOf(hitters))
                            _activeProjectsList.postValue(projectsList)

                        }

            }

    }

    fun onProjectItemClicked(projects:ActiveProjects) {
        _navigateToProjectDetails.value = projects

    }

}