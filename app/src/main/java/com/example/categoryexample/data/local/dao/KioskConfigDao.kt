package com.example.categoryexample.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.categoryexample.data.model.entity.KioskConfigEntity

@Dao
interface KioskConfigDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKioskConfig(config: KioskConfigEntity)

    @Query("SELECT * FROM kiosk_config LIMIT 1")
    suspend fun getKioskConfig(): KioskConfigEntity?
}