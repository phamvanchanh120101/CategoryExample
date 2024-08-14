package com.example.categoryexample.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.categoryexample.data.model.entity.ModelEntity

@Dao
interface ModelDao {
    @Query("SELECT * FROM models WHERE categoryId = :categoryId")
    suspend fun getModelsByCategory(categoryId: String): List<ModelEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModels(models: List<ModelEntity>)

    @Query("DELETE FROM models")
    suspend fun deleteAllModels()
}