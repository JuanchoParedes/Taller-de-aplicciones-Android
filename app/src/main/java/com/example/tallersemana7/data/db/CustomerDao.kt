package com.example.tallersemana7.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tallersemana7.data.entity.CustomerEntity

@Dao
interface CustomerDao {

    @Query("SELECT * FROM CUSTOMER")
    fun getAllCustomers(): List<CustomerEntity>

//    @Query("SELECT * FROM CUSTOMER WHERE managerUsername = :managerUsername")
//    fun getCustomersByManager(managerUserName: String): List<CustomerEntity>

    @Query("SELECT * FROM CUSTOMER WHERE identification = :identification")
    fun getCustomerByIdentification(identification: String): CustomerEntity

    @Insert
    fun insertCustomer(customer: CustomerEntity)

    @Delete
    fun deleteCustomer(customer: CustomerEntity)

}