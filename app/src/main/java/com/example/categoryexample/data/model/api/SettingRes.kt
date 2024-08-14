package com.example.categoryexample.data.model.api

data class SettingRes(
    val kiosk: KioskRes?,
    val mqtt: MqttRes?,
    val languages: List<String>,
    val work_flow: WorkFlowRes?,
    val system_setting: SystemSettingRes?
)
