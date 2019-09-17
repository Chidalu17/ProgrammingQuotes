package com.example.quotes.util.nd

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseViewModel: ViewModel() {

    private val disposable = CompositeDisposable()

    fun addDisposable(task: () -> Disposable){
        disposable.add(task())
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}