package com.example.tallersemana7.data.repository

import com.example.tallersemana7.data.db.ManagerDao
import com.example.tallersemana7.data.entity.mapToLocalEntity
import com.example.tallersemana7.data.preferences.SharedPrefsDataSource
import com.example.tallersemana7.domain.model.Manager
import com.example.tallersemana7.domain.repository.ManagerRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class ManagerRepositoryImpl(
    private val sharedPrefsDataSource: SharedPrefsDataSource,
    private val managerDao: ManagerDao
) : ManagerRepository {

    override fun findManager(): Boolean {
        return sharedPrefsDataSource.findManager()
    }

    override fun createManager(username: String, password: String): Completable {
        return managerDao.createManager(Manager(username, password).mapToLocalEntity())
            .andThen(sharedPrefsDataSource.registerManager(username))
    }

    override fun getManager(): Single<String> {
        return sharedPrefsDataSource.getManager()
    }

    override fun logIn(username: String, password: String): Single<Boolean> =
        managerDao.getManager(username, password).flatMapCompletable {
            sharedPrefsDataSource.registerManager(it.userName ?: "")
        }.toSingle { true }

    override fun logout(): Completable {
        return sharedPrefsDataSource.logoutManager()
    }
}