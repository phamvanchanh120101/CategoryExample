package com.example.categoryexample.data.model.api

data class ApiResponse<T>(
    val message: String,
    val data: T?,
    val code: Int
)