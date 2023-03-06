package com.example.tallersemana7.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tallersemana7.MutableEventLiveData
import com.example.tallersemana7.domain.usecase.GetManagerUseCase
import com.example.tallersemana7.domain.usecase.LogoutUseCase
import com.example.tallersemana7.ui.BaseViewModel
import io.reactivex.rxjava3.observers.DisposableCompletableObserver
import io.reactivex.rxjava3.observers.DisposableSingleObserver

class MainViewModel(
    private val logoutUseCase: LogoutUseCase,
    private val getManagerUseCase: GetManagerUseCase
) : BaseViewModel() {

    var logoutLiveData = MutableEventLiveData<Boolean>()
        private set

    var managerLiveData = MutableLiveData<String>()
        private set

    init {
        compositeDisposable.add(
            getManagerUseCase.invoke()
                .subscribeWith(object : DisposableSingleObserver<String>() {
                    override fun onSuccess(t: String) {
                        managerLiveData.value = t
                    }

                    override fun onError(e: Throwable) {
                        //do nothing
                    }
                })
        )
    }
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