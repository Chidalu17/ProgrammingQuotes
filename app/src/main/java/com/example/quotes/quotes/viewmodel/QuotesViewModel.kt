package com.example.quotes.quotes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotes.model.uimodel.ListUIModel
import com.example.quotes.quotes.dto.Quotes
import com.example.quotes.repository.repo.QuotesRepository
import com.example.quotes.util.nd.BaseViewModel
import com.example.quotes.util.nd.SchedulerProvider
import com.example.quotes.util.nd.getMsgFromErrBody
import com.example.quotes.util.nd.processNetworkError
import javax.inject.Inject

class QuotesViewModel @Inject
constructor(
    private val repo: QuotesRepository,
    private val provider: SchedulerProvider
) : BaseViewModel(){

    private val allQuotesUI = MutableLiveData<ListUIModel<Quotes>>()


    fun getQuotes(): LiveData<ListUIModel<Quotes>> {
        getAllQuotes()
        return allQuotesUI
    }

    private fun getAllQuotes(){
        addDisposable {
            allQuotesUI.postValue(ListUIModel(isLoading = true))
            repo.getAllQuotes()
                .subscribeOn(provider.io())
                .observeOn(provider.ui())
                .subscribe({
                    Log.e("QuotesViewModel ",it.toString())
                    if(!it.isNullOrEmpty())
                        allQuotesUI.postValue(ListUIModel(list = it))
                    else
                        allQuotesUI.postValue(ListUIModel(error = getMsgFromErrBody("error_here")))
                }, {
                    allQuotesUI.postValue(ListUIModel(error = processNetworkError(it)))
                })

        }
    }


}