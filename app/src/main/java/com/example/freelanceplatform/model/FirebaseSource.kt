package com.example.freelanceplatform.model

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import io.reactivex.Completable

class FirebaseSource {

    private val firebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    private val firebaseFirestore: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }

    val activeProjects = firebaseFirestore.collection("freelancer").limit(25)
    private val projectsList = ArrayList<ActiveProjects>()

    var next: Query? = null


    fun getActiveProjects(onSuccess: (List<ActiveProjects>) -> Unit) {
        val nextQuery = next
        if(nextQuery!=null){
            nextQuery.get()
                .addOnSuccessListener {projectsSnapshots ->

                    val lastVisible = projectsSnapshots.documents[projectsSnapshots.size() -1]
                    next =  firebaseFirestore.collection("freelancer")
                        .startAfter(lastVisible)
                        .limit(25)

                    onSuccess(projectsSnapshots.map {
                        val projects = it.toObject(ActiveProjects::class.java)
//                        record.id = it.id
                        projects
                    })

                }
        }

    }

    fun login(email: String, password: String) = Completable.create { emitter ->
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!emitter.isDisposed) {
                if (it.isSuccessful)
                    emitter.onComplete()
                else
                    emitter.onError(it.exception!!)
            }
        }
    }

    fun register(email: String, password: String) = Completable.create { emitter ->
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!emitter.isDisposed) {
                if (it.isSuccessful)
                    emitter.onComplete()
                else
                    emitter.onError(it.exception!!)
            }
        }
    }

    fun saveFreelancerCredentials(firstName: String, lastName: String) {

        val freelancer = HashMap<String, Any>()
        freelancer.put("firstName", firstName)
        freelancer.put("lastName", lastName)

        firebaseFirestore.collection("FreelancerData").document(firebaseAuth.currentUser!!.uid)
            .set(freelancer)
            .addOnSuccessListener {

            }
            .addOnFailureListener {

            }
    }

    fun logout() = firebaseAuth.signOut()

    fun currentUser() = firebaseAuth.currentUser

}