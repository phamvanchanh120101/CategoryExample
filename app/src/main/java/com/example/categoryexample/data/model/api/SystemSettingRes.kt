package com.example.categoryexample.data.model.api

data class SystemSettingRes(
    val systemName: String,
    val lastSaved: String?,
    val enable2FA: Boolean
)