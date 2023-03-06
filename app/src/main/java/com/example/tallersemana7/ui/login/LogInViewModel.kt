package com.example.tallersemana7.ui.login

import androidx.lifecycle.MutableLiveData
import com.example.tallersemana7.domain.usecase.LogInUseCase
import com.example.tallersemana7.ui.BaseViewModel
import io.reactivex.rxjava3.observers.DisposableSingleObserver

class LogInViewModel(
    private val useCase: LogInUseCase
) : BaseViewModel() {

    var logInProcessLiveData = MutableLiveData<Boolean>()
        private set

    fun logIn(username: String, password: String) {
        compositeDisposable.add(
            useCase.invoke(username, password)
                .subscribeWith(object : DisposableSingleObserver<Boolean>() {
                    override fun onSuccess(t: Boolean) {
                        logInProcessLiveData.value = t
                    }

                    override fun onError(e: Throwable) {
                        logInProcessLiveData.value = false
                    }
                })
        )
    }
}