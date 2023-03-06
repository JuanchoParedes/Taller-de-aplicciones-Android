package com.example.tallersemana7.ui.customersbymanager

import androidx.lifecycle.MutableLiveData
import com.example.tallersemana7.domain.usecase.GetCustomersByManagerUseCase
import com.example.tallersemana7.ui.BaseViewModel
import com.example.tallersemana7.ui.customersbymanager.adapter.CustomerAdapterItem
import com.example.tallersemana7.ui.customersbymanager.adapter.mapToPresentation

class CustomersByManagerViewModel(
    useCase: GetCustomersByManagerUseCase
) : BaseViewModel() {

    var customersByManagerLiveData = MutableLiveData<List<CustomerAdapterItem>>()
        private set

    init {
        compositeDisposable.add(
            useCase.invoke()
                .forEach {
                    customersByManagerLiveData.value = it.mapToPresentation()
                }
        )
    }
}