package com.example.the17odsapp

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User( val userName: String,
                 val email: String,
                val calle: String,
                 val nExterior: String,
                 val cPostal: String,
                 val colonia: String,
                 val ciudad: String,
                 val estado: String,
                 val pais: String
)
