package com.example.tallersemana7.data.repository

import com.example.tallersemana7.data.db.ManagerDao
import com.example.tallersemana7.data.entity.mapToLocalEntity
import com.example.tallersemana7.data.preferences.SharedPrefsDataSource
import com.example.tallersemana7.domain.model.Manager
import com.example.tallersemana7.domain.repository.ManagerRepository

class ManagerRepositoryImpl(
    private val sharedPrefsDataSource: SharedPrefsDataSource,
    private val managerDao: ManagerDao
) : ManagerRepository {

    override fun findManager(): Boolean {
        return sharedPrefsDataSource.findManager()
    }

    override fun createManager(username: String, password: String) {
        managerDao.createManager(Manager(username, password).mapToLocalEntity())
        sharedPrefsDataSource.registerManager(username)
    }

    override fun logIn(username: String, password: String) {
        managerDao.getManager(username, password)
    }
}