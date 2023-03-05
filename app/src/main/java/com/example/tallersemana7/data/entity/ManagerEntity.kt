package com.example.tallersemana7.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MANAGER")
data class ManagerEntity(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    val userName: String,
    val password: String,
    var associatedCustomers: List<CustomerEntity>
)