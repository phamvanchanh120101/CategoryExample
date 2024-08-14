package com.example.categoryexample.data.model.api

data class TerminalRes(
    val name: String,
    val status: Int,
    val terminal_id: String,
    val item_detector: Boolean
)