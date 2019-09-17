package com.example.quotes.model.uimodel

data class DataUIModel<T>(
    var isLoading: Boolean = false,
    var data: T? = null,
    var error: String? = ""
)

data class ListUIModel<T>(
    var isLoading: Boolean = false,
    var list: List<T>? = null,
    var error: String? = ""
)

data class GenericUIModel(
    var isLoading: Boolean = false,
    var message: String? = "",
    var error: String? = ""
)