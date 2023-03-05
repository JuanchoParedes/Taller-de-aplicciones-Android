package com.example.tallersemana7.data.repository

import com.example.tallersemana7.data.preferences.SharedPrefsDataSource
import com.example.tallersemana7.domain.repository.ManagerRepository

class ManagerRepositoryImpl(
    private val dataSource: SharedPrefsDataSource
): ManagerRepository {

    override fun findManager(): Boolean {
        return dataSource.findManager()
    }
}