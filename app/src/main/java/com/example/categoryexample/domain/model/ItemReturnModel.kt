package com.example.categoryexample.domain.model

data class ItemReturnModel(
    val transactionId: String,
    val serialNumber: String,
    val modelName: String,
    val modelId: String,
    val categoryName: String,
    val categoryId: String,
    val loaneeEmail: String
)