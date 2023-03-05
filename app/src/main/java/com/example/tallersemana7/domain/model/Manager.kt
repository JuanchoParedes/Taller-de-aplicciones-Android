package com.example.tallersemana7.domain.model

data class Manager(
    val username: String,
    val password: String,
    val associatedCustomers: List<Customer> = listOf()
)