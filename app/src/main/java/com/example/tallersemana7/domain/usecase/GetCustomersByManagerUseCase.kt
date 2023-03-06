package com.example.tallersemana7.domain.usecase

import com.example.tallersemana7.domain.model.Customer
import com.example.tallersemana7.domain.repository.CustomerRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

class GetCustomersByManagerUseCase(
    private val customerRepository: CustomerRepository
) {

    operator fun invoke(): Flowable<List<Customer>> {
        return customerRepository.getCustomersByManager()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}