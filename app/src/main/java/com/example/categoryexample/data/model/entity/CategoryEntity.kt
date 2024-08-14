package com.example.categoryexample.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey val categoryId: String,
    val categoryName: String,
    val limit: Int,
    val position: Int,
    val image: String
)