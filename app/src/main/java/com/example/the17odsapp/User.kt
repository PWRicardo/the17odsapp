package com.example.the17odsapp

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User( val userName: String? = null, val email: String? = null)
