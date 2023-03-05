package com.example.tallersemana7.data.model

import androidx.room.Entity

@Entity(tableName = "CUSTOMER")
data class CustomerEntity(
    val name: String,
    val lastName: String,
    val identification: String,
    val phone: String,
    val email: String
)
