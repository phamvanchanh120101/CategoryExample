package com.example.categoryexample.domain.repository

import android.util.Log
import com.example.categoryexample.data.local.dao.CategoryDao
import com.example.categoryexample.data.local.dao.KioskConfigDao
import com.example.categoryexample.data.local.dao.ModelDao
import com.example.categoryexample.data.local.mapper.toDomain
import com.example.categoryexample.data.local.mapper.toEntity
import com.example.categoryexample.data.network.ApiService
import com.example.categoryexample.domain.model.CategoryModel
import com.example.categoryexample.domain.model.KioskConfigModel
import com.example.categoryexample.domain.model.Model
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class DataRepository (
    private val apiService: ApiService,
    private val kioskConfigDao: KioskConfigDao,
    private val categoryDao: CategoryDao,
    private val modelDao: ModelDao
) {
    suspend fun getKioskConfig(): KioskConfigModel? {
        return kioskConfigDao.getKioskConfig()?.toDomain()
    }

    suspend fun getCategories(): List<CategoryModel> {
        return categoryDao.getAllCategories().map { it.toDomain() }
    }

    suspend fun getModelsByCategory(categoryId: String): List<Model> {
        return modelDao.getModelsByCategory(categoryId).map { it.toDomain() }
    }

    suspend fun refreshData() {
        withContext(Dispatchers.IO) {
            try {
                // Gọi API để thực hiện terminal login và lấy response
                val loginResponse = apiService.teminalLogin("48598cef8a31f6f19655")
                // Lấy đối tượng KioskConfigRes từ response
                val kioskConfigRes = loginResponse.data?.setting?.kiosk?.kiosk_config

                // Gọi API để lấy danh sách category
                val categorydataRes = apiService.getListCategory(loginResponse.data!!.api_token)

                // Kiểm tra nếu kioskConfigRes không null và xử lý dữ liệu
                kioskConfigRes?.let {
                    // Chuyển đổi từ KioskConfigRes sang KioskConfigEntity
                    val kioskConfigEntity = it.toEntity()

                    // Insert hoặc update KioskConfigEntity trong local database
                    kioskConfigDao.insertKioskConfig(kioskConfigEntity)
                } ?: run {
                    Log.e("Error", "KioskConfigRes is null")
                }

                // Lưu category data xuống local database
                categorydataRes.data?.categories.let { categories ->
                    val categoryEntities = categories?.map { it.toEntity() }
                    val modelEntities = categories?.flatMap { category ->
                        category.models.map { model -> model.toEntity(category.category_id) }
                    }

                    // Xóa dữ liệu cũ và insert dữ liệu mới vào database
                    categoryDao.deleteAllCategories()
                    modelDao.deleteAllModels()
                    categoryDao.insertCategories(categoryEntities!!)
                    modelDao.insertModels(modelEntities!!)
                } ?: run {
                    Log.e("Error", "Category data is null")
                }

            } catch (e: IOException) {
                // Xử lý các ngoại lệ liên quan đến mạng hoặc API
                Log.e("Error", "Network or API error: ${e.message}")
                throw e
            } catch (e: Exception) {
                // Xử lý các ngoại lệ khác
                Log.e("Error", "Unexpected error: ${e.message}")
                throw e
            }
        }
    }


}