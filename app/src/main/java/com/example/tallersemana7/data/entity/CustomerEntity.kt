package com.example.tallersemana7.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CUSTOMER")
class CustomerEntity {
    @PrimaryKey(autoGenerate = true)
    var _id: Int? = null
    var name: String? = null
    var lastName: String? = null
    var identification: String? = null
    var phone: String? = null
    var email: String? = null
    var managerUsername: String? = null
}
