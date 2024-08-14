package com.example.categoryexample.data.model.api

data class CategoriesListApiRes(
    val categories: List<CategoryRes>
)

data class CategoryRes(
    val category_id: String,
    val category_name: String,
    val limit: Int,
    val position: Int,
    val image: String,
    val models: List<ModelRes>,
    val reason_faulties: List<String>
)