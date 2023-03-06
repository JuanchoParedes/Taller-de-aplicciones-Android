package com.example.tallersemana7.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tallersemana7.domain.model.Customer

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

fun CustomerEntity.mapToDomain() = Customer(
    name.orEmpty(), lastName.orEmpty(), identification.orEmpty(), phone.orEmpty(), email.orEmpty()
)

fun List<CustomerEntity>.mapToDomain() = this.map { it.mapToDomain() }
