package com.example.tallersemana7.domain.repository

import com.example.tallersemana7.domain.model.Customer
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface CustomerRepository {

    fun getCustomersByManager(): Flowable<List<Customer>>

    fun addCustomer(
        name: String,
        lastName: String,
        identification: String,
        email: String,
        phone: String
    ): Completable

    fun getCustomerByIdentification(identification: String): Single<Customer>

    fun deleteCustomer(customerId: String): Completable

}