package com.example.tallersemana7.ui.splash

import androidx.lifecycle.MutableLiveData
import com.example.tallersemana7.domain.usecase.FindManagerUseCase
import com.example.tallersemana7.ui.BaseViewModel

class SplashViewModel(
    findManagerUseCase: FindManagerUseCase
) : BaseViewModel() {

    var findManagerLiveData = MutableLiveData<Boolean>()
        private set

    init {
        findManagerLiveData.value = findManagerUseCase.invoke()
    }

}