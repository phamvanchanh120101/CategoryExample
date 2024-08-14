package com.example.categoryexample.data.local.mapper

import com.example.categoryexample.data.model.api.ModelRes
import com.example.categoryexample.data.model.entity.ModelEntity
import com.example.categoryexample.domain.model.Model

fun ModelRes.toEntity(categoryId: String): ModelEntity {
    return ModelEntity(
        modelId = this.model_id,
        modelName = this.model_name,
        limit = this.limit,
        position = this.position,
        image = this.image,
        categoryId = categoryId
    )
}

fun ModelEntity.toDomain() = Model(
    id = modelId,
    name = modelName,
    limit = limit,
    position = position,
    image = image,
    categoryId = categoryId
)