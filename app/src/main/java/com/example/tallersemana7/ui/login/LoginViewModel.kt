package com.example.tallersemana7.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tallersemana7.usecase.FindManagerUseCase

class LoginViewModel(
    findManagerUseCase: FindManagerUseCase
) : ViewModel() {

    var findManagerLiveData = MutableLiveData<Boolean>()
        private set

    init {
        findManagerLiveData.value = findManagerUseCase.invoke()
    }

}