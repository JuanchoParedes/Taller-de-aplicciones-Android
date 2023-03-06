package com.example.tallersemana7.domain.usecase

import com.example.tallersemana7.domain.repository.CustomerRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

class CreateCustomerUseCase(
    private val repository: CustomerRepository
) {

    operator fun invoke(
        name: String,
        lastName: String,
        identification: String,
        email: String,
        phone: String
    ): Completable {
        return repository.addCustomer(name, lastName, identification, email, phone)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}