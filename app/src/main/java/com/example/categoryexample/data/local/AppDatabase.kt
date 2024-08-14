package com.example.categoryexample.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.categoryexample.data.local.dao.CategoryDao
import com.example.categoryexample.data.local.dao.KioskConfigDao
import com.example.categoryexample.data.local.dao.ModelDao
import com.example.categoryexample.data.model.entity.CategoryEntity
import com.example.categoryexample.data.model.entity.KioskConfigEntity
import com.example.categoryexample.data.model.entity.ModelEntity

@Database(
    entities = [CategoryEntity::class, ModelEntity::class, KioskConfigEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun kioskConfigDao(): KioskConfigDao
    abstract fun categoryDao(): CategoryDao
    abstract fun modelDao(): ModelDao

    companion object {
        private const val DATABASE_NAME = "SmartLocker"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
