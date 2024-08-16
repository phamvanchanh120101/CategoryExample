package com.example.categoryexample.domain.model

data class LockerInfo(
    val lockerId: String,
    val lockerName: String,
    val serialNumber: String,
    val modelName: String,
    val modelId: String,
    val categoryName: String
)