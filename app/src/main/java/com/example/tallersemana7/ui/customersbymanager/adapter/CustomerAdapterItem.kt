package com.example.tallersemana7.ui.customersbymanager.adapter

import com.example.tallersemana7.domain.model.Customer

class CustomerAdapterItem(
    var name: String,
    var lastName: String,
    var identification: String,
    var phone: String,
    var email: String
)

fun Customer.mapToPresentation() = CustomerAdapterItem(
    name, lastName, identification, phone, email
)

fun List<Customer>.mapToPresentation() = this.map { it.mapToPresentation() }