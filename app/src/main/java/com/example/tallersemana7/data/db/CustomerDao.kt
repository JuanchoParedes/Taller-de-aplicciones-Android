package com.example.tallersemana7.data.db

import androidx.room.*
import com.example.tallersemana7.data.entity.CustomerEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface CustomerDao {

    @Query("SELECT * FROM CUSTOMER")
    fun getAllCustomers(): List<CustomerEntity>

    @Query("SELECT * FROM CUSTOMER WHERE managerUsername = :managerUserName")
    fun getCustomersByManager(managerUserName: String): Flowable<List<CustomerEntity>>

    @Query("SELECT * FROM CUSTOMER WHERE identification = :identification")
    fun getCustomerByIdentification(identification: String): CustomerEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCustomer(customer: CustomerEntity): Completable

    @Delete
    fun deleteCustomer(customer: CustomerEntity)

}