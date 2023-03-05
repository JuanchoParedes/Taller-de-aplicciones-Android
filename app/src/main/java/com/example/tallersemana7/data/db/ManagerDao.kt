package com.example.tallersemana7.data.db

import androidx.room.Dao
import androidx.room.Query
import com.example.tallersemana7.data.entity.ManagerEntity

@Dao
abstract class ManagerDao {

    @Query("SELECT * FROM MANAGER WHERE userName = :userName AND password = :password")
    abstract fun getManager(userName: String, password: String): ManagerEntity?

}