package com.example.freelanceplatform.model

import com.google.firebase.firestore.Exclude




data class Freelancer( val firstName:String?=null, val lastName:String?=null)
{
    @Exclude
    var isAuthenticated = false
    @Exclude
    var isNew = false
    @Exclude
    var isCreated = false
}