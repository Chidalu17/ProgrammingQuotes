package com.example.quotes.quotes.di

import androidx.lifecycle.ViewModel
import com.example.quotes.di.vmfactory.ViewModelKey
import com.example.quotes.quotes.viewmodel.QuotesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class QuotesViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(QuotesViewModel::class)
    abstract fun bindsRecipeViewModel(tournamentViewModel: QuotesViewModel): ViewModel
}