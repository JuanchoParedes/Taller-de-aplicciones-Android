package com.example.tallersemana7.domain.repository

interface ManagerRepository {

    fun findManager(): Boolean

    fun createManager(username: String, password: String)

    fun logIn(username: String, password: String)
}