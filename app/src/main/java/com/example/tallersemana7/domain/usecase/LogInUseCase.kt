package com.example.tallersemana7.domain.usecase

import com.example.tallersemana7.domain.repository.ManagerRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class LogInUseCase(
    private val repository: ManagerRepository
) {

    operator fun invoke(userName: String, password: String): Single<Boolean> {
       return  repository.logIn(userName, password)
           .observeOn(AndroidSchedulers.mainThread())
           .subscribeOn(Schedulers.io())
    }
}