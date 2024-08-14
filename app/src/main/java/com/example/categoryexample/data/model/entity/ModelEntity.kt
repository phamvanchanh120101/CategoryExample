package com.example.categoryexample.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "models")
data class ModelEntity(
    @PrimaryKey val modelId: String,
    val modelName: String,
    val limit: Int,
    val position: Int,
    val image: String,
    val categoryId: String
)