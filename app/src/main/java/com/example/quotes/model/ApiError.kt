package com.example.quotes.model

import com.google.gson.annotations.SerializedName

class ApiError {

    @SerializedName("error")
    var error: Error? = null
}
