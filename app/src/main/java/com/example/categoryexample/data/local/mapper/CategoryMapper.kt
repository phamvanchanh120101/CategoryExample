package com.example.categoryexample.data.local.mapper

import com.example.categoryexample.data.model.api.CategoryRes
import com.example.categoryexample.data.model.entity.CategoryEntity
import com.example.categoryexample.domain.model.CategoryModel

fun CategoryRes.toEntity(): CategoryEntity {
    return CategoryEntity(
        categoryId = this.category_id,
        categoryName = this.category_name,
        limit = this.limit,
        position = this.position,
        image = this.image
    )
}

fun CategoryEntity.toDomain() = CategoryModel(
    id = categoryId,
    name = categoryName,
    limit = limit,
    position = position,
    image = image
)
