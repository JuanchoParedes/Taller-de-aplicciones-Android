package com.example.tallersemana7.ui.main

import com.example.tallersemana7.MutableEventLiveData
import com.example.tallersemana7.domain.usecase.LogoutUseCase
import com.example.tallersemana7.ui.BaseViewModel
import io.reactivex.rxjava3.observers.DisposableCompletableObserver

class MainViewModel(
    private val logoutUseCase: LogoutUseCase
) : BaseViewModel() {

    var logoutLiveData = MutableEventLiveData<Boolean>()
        private set

    fun logOut() {
        compositeDisposable.add(
            logoutUseCase.invoke()
                .subscribeWith(object : DisposableCompletableObserver() {
                    override fun onComplete() {
                        logoutLiveData.setData(true)
                    }

                    override fun onError(e: Throwable) {
                        logoutLiveData.setData(false)
                    }
                })
        )
    }
}