package com.example.quotes.quotes.di

import com.example.quotes.di.modules.ViewModelFactoryModule
import com.example.quotes.quotes.fragment.QuoteHomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class QuotesFragmentProvider {
    @ContributesAndroidInjector(modules = [QuotesFragmentModule::class,
        ViewModelFactoryModule::class, QuotesViewModelModule::class])
    internal abstract fun contributeRecipeHomeFragment(): QuoteHomeFragment
}