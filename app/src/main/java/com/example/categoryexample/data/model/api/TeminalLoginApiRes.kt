package com.example.categoryexample.data.model.api

data class TeminalLoginApiRes (
    val api_token: String,
    val terminal: TerminalRes?,
    val setting: SettingRes?
)