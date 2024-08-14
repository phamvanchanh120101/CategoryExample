package com.example.categoryexample.data.network

import com.example.categoryexample.data.model.api.ApiResponse
import com.example.categoryexample.data.model.api.CategoriesListApiRes
import com.example.categoryexample.data.model.api.TeminalLoginApiRes
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("api/auth/terminal-login")
    suspend fun teminalLogin(@Header("terminal_id") terminalId: String): ApiResponse<TeminalLoginApiRes>

    @GET("api/terminal/list-category")
    suspend fun getListCategory(@Header("api_token") apiToken: String): ApiResponse<CategoriesListApiRes>
}
