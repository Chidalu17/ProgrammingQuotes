package com.example.quotes.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.quotes.di.vmfactory.AppViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}