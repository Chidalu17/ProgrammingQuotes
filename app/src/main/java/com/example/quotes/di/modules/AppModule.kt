package com.example.quotes.di.modules

import android.app.Application
import androidx.room.Room
import com.example.quotes.repository.local.ApplicationDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    internal fun provideApplicationDatabase(context: Application): ApplicationDatabase {
        return Room.databaseBuilder(context, ApplicationDatabase::class.java, "RecipeDb")
            .fallbackToDestructiveMigration()
            .build()
    }


}