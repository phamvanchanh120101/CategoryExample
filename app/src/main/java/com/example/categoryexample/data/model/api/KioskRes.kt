package com.example.categoryexample.data.model.api

data class KioskRes(
    val kiosk_config: KioskConfigRes?
)

data class KioskConfigRes(
    val home_screen_logo: String,
    val sub_screen_logo: String,
    val home_screen_background: String,
    val sub_screen_background: String,
    val owner_text: String,
    val owner_image: String,
    val email_domain: String,
    val administrator_support_email: String,
    val order_category_on_kiosk: String,
    val order_model_on_kiosk: String,
    val enable_internal_delivery: String,
    val auto_trigger_delay: String,
    val auto_next_page: String,
    val check_door_status_on_confirm: String,
    val mandatory_door_closure_verification: String
)