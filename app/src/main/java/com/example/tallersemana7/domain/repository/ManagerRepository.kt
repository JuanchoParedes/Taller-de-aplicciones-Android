package com.example.tallersemana7.domain.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface ManagerRepository {

    fun findManager(): Boolean

    fun createManager(username: String, password: String): Completable

    fun getManager(): Single<String>

    fun logIn(username: String, password: String): Single<Boolean>

    fun logout(): Completable
}