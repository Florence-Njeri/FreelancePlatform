package com.example.freelanceplatform.model

import com.google.firebase.Timestamp


data class ActiveProjects(val status:String?=null, val cost:String?=null, val name:String?=null, val projectDescription:String?=null, val projectTitle:String?=null, val timePosted:Timestamp?=null)
