package com.example.quotes.quotes.dto

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "quotes")
data class Quotes(

    @PrimaryKey
    @NonNull
    var _id: String= "",
    var author: String? = "",
    var en: String? = "",
    var rating: Double? = null
)

