package com.example.tallersemana7.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tallersemana7.model.Customer

@Dao
interface CustomerDao {

    @Query("SELECT * FROM CUSTOMER")
    fun getAllCustomers(): List<Customer>

    @Query("SELECT * FROM CUSTOMER WHERE identification = :identification")
    fun getCustomerByIdentification(identification: String)

    @Insert
    fun insertCustomer(customer: Customer)

    @Delete
    fun deleteCustomer(customer: Customer)
}