package com.example.quotes.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.quotes.quotes.dto.Quotes

@Database(entities = [
   Quotes::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun quotesDAO(): QuotesDAO


}