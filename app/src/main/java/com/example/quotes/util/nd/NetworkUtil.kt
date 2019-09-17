package com.example.quotes.util.nd

import android.util.MalformedJsonException
import com.example.quotes.model.ApiError
import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException


fun processNetworkError(throwable: Throwable): String{
    throwable.printStackTrace()
    var message: String? = null
    when(throwable) {
        is HttpException -> {
            when (throwable.code()){
                400 -> message = try{
                    val errorBody = throwable.response().errorBody()?.string()
                    val err = Gson().fromJson<ApiError>(errorBody, ApiError::class.java)
                    err.error?.message
                } catch(e: Exception ){
                    e.printStackTrace()
                    throwable.message
                }
                401 -> return  "unauthorized user, you have been logged out"
                403 -> return  "already logged onto another device"
            }
        }
        is SocketTimeoutException -> message = "Network poor! Ensure better connection and try again"
        is MalformedJsonException -> message = "Technical error! Please try again"
        is IOException -> message = "Network error"
        else -> message = throwable.message
    }
    return message ?: "Internal error"
}

fun getMsgFromErrBody(errorBody: String?): String? =
    try{
        val err = Gson().fromJson<ApiError>(errorBody, ApiError::class.java)
        err.error?.message
    } catch(e: Exception ){
        e.printStackTrace()
        e.message
    }