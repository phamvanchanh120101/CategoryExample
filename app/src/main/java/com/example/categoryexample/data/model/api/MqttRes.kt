package com.example.categoryexample.data.model.api

data class MqttRes(
    val host: String,
    val port: Int,
    val client_id: String,
    val username: String,
    val password: String,
    val project_code: String
)