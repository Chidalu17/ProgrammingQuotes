package com.example.quotes.repository.local

import androidx.room.TypeConverter
import com.example.quotes.quotes.dto.Quotes

import com.google.gson.Gson

class Converters {
    companion object {
        val gson = Gson()

        @TypeConverter
        @JvmStatic
        fun fromQuotes(value: List<Quotes>): String {
            return gson.toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun toQuotes(value: String): List<Quotes> {
            return gson.fromJson(value, Array<Quotes>::class.java).asList()
        }





    }
}