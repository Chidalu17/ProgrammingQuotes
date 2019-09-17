package com.example.quotes.di.builders

import com.example.quotes.QuotesActivity
import com.example.quotes.di.modules.ViewModelFactoryModule
import com.example.quotes.quotes.di.QuotesFragmentModule
import com.example.quotes.quotes.di.QuotesFragmentProvider
import com.example.quotes.quotes.di.QuotesViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
 abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [QuotesFragmentProvider::class,
        QuotesFragmentModule::class, ViewModelFactoryModule::class, QuotesViewModelModule::class])
    internal abstract fun contributeQuotesActivity(): QuotesActivity

}