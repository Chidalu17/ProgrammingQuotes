package com.example.quotes.repository.repo

import com.example.quotes.quotes.dto.Quotes
import com.example.quotes.repository.local.QuotesDAO
import com.example.quotes.repository.remote.QuotesApiService
import com.example.quotes.util.nd.SchedulerProvider
import io.reactivex.Observable


open class QuotesRepository(
    private val apiService: QuotesApiService,
    private val quotesDao: QuotesDAO,
    private val provider: SchedulerProvider
){

    fun getAllQuotes(): Observable<List<Quotes>> =
        Observable.concat(getQuotesFromDb(), getQuotesFromApi())
            .onErrorResumeNext(Observable.empty())

    private fun saveQuotes(quotes: List<Quotes>) =
        quotesDao.addQuotes(quotes)

    private fun getQuotesFromDb(): Observable<List<Quotes>> =
        Observable.fromCallable { quotesDao.getAllQuotes() }
            .filter { !it.isNullOrEmpty() }
            .subscribeOn(provider.io())

    private fun getQuotesFromApi(): Observable<List<Quotes>> =
        apiService.getAllQuotes()
            .subscribeOn(provider.io())
            .doOnNext {
                if(it.isSuccessful && !it.body()?.isNullOrEmpty()!!)
                    saveQuotes(it.body()!!)
            }
            .map {
                it.body()
            }
}