package com.example.tallersemana7.ui

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()

        super.onCleared()
    }
}