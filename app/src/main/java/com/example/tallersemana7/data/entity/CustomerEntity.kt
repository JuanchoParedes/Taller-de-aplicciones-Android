package com.example.tallersemana7.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CUSTOMER")
data class CustomerEntity(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    val name: String,
    val lastName: String,
    val identification: String,
    val phone: String,
    val email: String,
    val managerUsername: String
)
