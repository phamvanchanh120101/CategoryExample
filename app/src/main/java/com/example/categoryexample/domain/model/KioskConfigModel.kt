package com.example.categoryexample.domain.model

data class KioskConfigModel(
    val homeScreenLogo: String,
    val subScreenLogo: String,
    val homeScreenBackground: String,
    val subScreenBackground: String,
    val ownerText: String,
    val ownerImage: String,
    val emailDomain: String,
    val administratorSupportEmail: String,
    val orderCategoryOnKiosk: String,
    val orderModelOnKiosk: String,
    val enableInternalDelivery: String,
    val autoTriggerDelay: String,
    val autoNextPage: String,
    val checkDoorStatusOnConfirm: String,
    val mandatoryDoorClosureVerification: String
)