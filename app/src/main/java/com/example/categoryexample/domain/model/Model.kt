package com.example.categoryexample.domain.model

data class Model(
    val id: String,
    val name: String,
    val limit: Int,
    val position: Int,
    val image: String,
    val categoryId: String
)
