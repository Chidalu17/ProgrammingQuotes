package com.example.quotes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListResp<T> {

    @SerializedName("code")
    @Expose
    var code: Int = 0

    @SerializedName("list")
    @Expose
    var list: List<T>? = null

    @SerializedName("error")
    @Expose
    var error: Error? = null

    @SerializedName("message")
    @Expose
    var message: String? = null
}
