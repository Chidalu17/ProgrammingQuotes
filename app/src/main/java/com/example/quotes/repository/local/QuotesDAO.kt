package com.example.quotes.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quotes.quotes.dto.Quotes

@Dao
interface QuotesDAO{
    @Query("select * from quotes")
    fun getAllQuotes(): List<Quotes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuotes(quotes: List<Quotes>)

    @Query("DELETE FROM quotes")
    fun clearAllQuotesTable()
}