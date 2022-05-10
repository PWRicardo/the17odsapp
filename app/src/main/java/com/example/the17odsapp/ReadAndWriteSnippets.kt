package com.example.the17odsapp

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

abstract class ReadAndWriteSnippets {

    private lateinit var database: DatabaseReference


    fun initialzeDbRef() {
        database = Firebase.database.reference
    }

    fun writeNewUser(userId: String, name: String, email: String) {
        val user = User(name, email)

        database.child("users").child(userId).setValue(user)
    }

}