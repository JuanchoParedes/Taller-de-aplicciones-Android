package com.example.tallersemana7.data.repository

import com.example.tallersemana7.data.db.CustomerDao
import com.example.tallersemana7.data.entity.CustomerEntity
import com.example.tallersemana7.data.entity.mapToDomain
import com.example.tallersemana7.data.preferences.SharedPrefsDataSource
import com.example.tallersemana7.domain.model.Customer
import com.example.tallersemana7.domain.repository.CustomerRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

class CustomerRepositoryImpl(
    private val sharedPrefsDataSource: SharedPrefsDataSource,
    private val dao: CustomerDao
) : CustomerRepository {

    override fun getCustomersByManager(): Flowable<List<Customer>> {
        return sharedPrefsDataSource.getManager()
            .toFlowable()
            .flatMap { managerUsername ->
                dao.getCustomersByManager(managerUsername).map {
                    it.mapToDomain()
                }
            }
    }

    override fun addCustomer(
        name: String,
        lastName: String,
        identification: String,
        email: String,
        phone: String
    ): Completable {
        return sharedPrefsDataSource.getManager()
            .flatMapCompletable { managerUserName ->
                val customer = CustomerEntity().apply {
                    this.name = name
                    this.lastName = lastName
                    this.identification = identification
                    this.email = email
                    this.phone = phone
                    this.managerUsername = managerUserName
                }
                dao.insertCustomer(customer)
            }
    }

    override fun getCustomerByIdentification(identification: String): Single<Customer> {
        TODO("Not yet implemented")
    }

    override fun deleteCustomer(customerId: String): Completable {
        TODO("Not yet implemented")
    }
}