package com.example.tallersemana7.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MANAGER")
data class ManagerEntity(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    val name: String,
    var customerList: List<CustomerEntity>
)