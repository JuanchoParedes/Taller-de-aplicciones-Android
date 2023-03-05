package com.example.tallersemana7.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tallersemana7.domain.usecase.FindManagerUseCase

class MainViewModel(
    findManagerUseCase: FindManagerUseCase
) : ViewModel() {

    var findManagerLiveData = MutableLiveData<Boolean>()
        private set

    init {
        findManagerLiveData.value = findManagerUseCase.invoke()
    }

}