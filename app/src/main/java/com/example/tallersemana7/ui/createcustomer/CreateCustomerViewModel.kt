package com.example.tallersemana7.ui.createcustomer

import androidx.lifecycle.MutableLiveData
import com.example.tallersemana7.MutableEventLiveData
import com.example.tallersemana7.domain.usecase.CreateCustomerUseCase
import com.example.tallersemana7.ui.BaseViewModel
import io.reactivex.rxjava3.observers.DisposableCompletableObserver

class CreateCustomerViewModel(
    private val useCase: CreateCustomerUseCase
): BaseViewModel() {

    var onCustomerCreatedSuccessLiveData = MutableEventLiveData<Boolean>()

    fun createCustomer(
        name: String,
        lastName: String,
        identification: String,
        email: String,
        phone: String
    ) {
        compositeDisposable.add(
            useCase.invoke(name, lastName, identification, email, phone)
                .subscribeWith(object : DisposableCompletableObserver() {
                    override fun onComplete() {
                        onCustomerCreatedSuccessLiveData.setData(true)
                    }

                    override fun onError(e: Throwable) {
                        onCustomerCreatedSuccessLiveData.setData(false)
                    }
                })
        )
    }
}