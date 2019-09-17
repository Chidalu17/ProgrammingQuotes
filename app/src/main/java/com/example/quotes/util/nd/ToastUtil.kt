package com.example.quotes.util.nd

import android.content.Context
import android.widget.Toast


fun showToast(context: Context, message: String?){
    var mToast: Toast? = null
    mToast?.cancel()
    mToast = Toast.makeText(context, message, Toast.LENGTH_LONG)
    mToast.show()
}