package com.example.tallersemana7.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tallersemana7.data.entity.ManagerEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
abstract class ManagerDao {

    @Query("SELECT * FROM MANAGER WHERE USERNAME = :userName AND PASSWORD = :password")
    abstract fun getManager(userName: String, password: String): Single<ManagerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun createManager(manager: ManagerEntity): Completable

}