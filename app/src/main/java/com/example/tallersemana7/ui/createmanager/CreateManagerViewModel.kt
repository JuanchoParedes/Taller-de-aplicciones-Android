package com.example.tallersemana7.ui.createmanager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tallersemana7.domain.usecase.CreateManagerUseCase
import com.example.tallersemana7.ui.BaseViewModel
import io.reactivex.rxjava3.observers.DisposableCompletableObserver

class CreateManagerViewModel(
    private val createManagerUseCase: CreateManagerUseCase
) : BaseViewModel() {

    var onManagerCreatedSuccessLiveData = MutableLiveData<Boolean>()
        private set

    fun createManager(userName: String, password: String) {
        compositeDisposable.add(
            createManagerUseCase.invoke(userName, password)
                .subscribeWith(object : DisposableCompletableObserver() {
                    override fun onComplete() {
                        onManagerCreatedSuccessLiveData.postValue(true)
                    }

                    override fun onError(e: Throwable) {
                        onManagerCreatedSuccessLiveData.postValue(false)
                    }
                })
        )
    }
}