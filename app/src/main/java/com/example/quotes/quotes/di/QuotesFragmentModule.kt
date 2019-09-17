package com.example.quotes.quotes.di

import com.example.quotes.repository.local.ApplicationDatabase
import com.example.quotes.repository.local.QuotesDAO
import com.example.quotes.repository.remote.QuotesApiService
import com.example.quotes.repository.repo.QuotesRepository
import com.example.quotes.util.nd.SchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class QuotesFragmentModule {

    @Provides
    internal fun providesRecipeRepository(apiService: QuotesApiService,
                                          tournamentDao:QuotesDAO, provider: SchedulerProvider
    )=QuotesRepository(apiService,tournamentDao,provider)

    @Provides
    internal fun providesRecipeApi(retrofit: Retrofit): QuotesApiService =
        retrofit.create(QuotesApiService::class.java)

    @Provides
    internal fun providesRecipeDao(applicationDatabase: ApplicationDatabase): QuotesDAO =
        applicationDatabase.quotesDAO()

}