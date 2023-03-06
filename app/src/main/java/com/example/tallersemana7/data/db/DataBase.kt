package com.example.tallersemana7.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tallersemana7.data.entity.CustomerEntity
import com.example.tallersemana7.data.entity.ManagerEntity

const val DATABASE_NAME = "CustomersDataBase"

@Database(
    entities = [ManagerEntity::class, CustomerEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DataBase: RoomDatabase() {

    abstract  fun managerDao(): ManagerDao

    abstract fun customerDao(): CustomerDao
}