package com.example.quotes.repository.remote

import com.example.quotes.model.ListResp
import com.example.quotes.quotes.dto.Quotes
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApiService {

    @GET("quotes/lang/en")
    fun getAllQuotes(): Observable<Response<List<Quotes>>>

}