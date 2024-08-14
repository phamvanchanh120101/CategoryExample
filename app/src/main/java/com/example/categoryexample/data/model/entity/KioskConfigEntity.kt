package com.example.categoryexample.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kiosk_config")
data class KioskConfigEntity(
    @PrimaryKey val id: Int = 1, // Đảm bảo có một khóa chính để Room có thể quản lý các bản ghi. Sử dụng giá trị mặc định là 1 cho đơn giản.
    @ColumnInfo(name = "home_screen_logo") val homeScreenLogo: String,
    @ColumnInfo(name = "sub_screen_logo") val subScreenLogo: String,
    @ColumnInfo(name = "home_screen_background") val homeScreenBackground: String,
    @ColumnInfo(name = "sub_screen_background") val subScreenBackground: String,
    @ColumnInfo(name = "owner_text") val ownerText: String,
    @ColumnInfo(name = "owner_image") val ownerImage: String,
    @ColumnInfo(name = "email_domain") val emailDomain: String,
    @ColumnInfo(name = "administrator_support_email") val administratorSupportEmail: String,
    @ColumnInfo(name = "order_category_on_kiosk") val orderCategoryOnKiosk: String,
    @ColumnInfo(name = "order_model_on_kiosk") val orderModelOnKiosk: String,
    @ColumnInfo(name = "enable_internal_delivery") val enableInternalDelivery: String,
    @ColumnInfo(name = "auto_trigger_delay") val autoTriggerDelay: String,
    @ColumnInfo(name = "auto_next_page") val autoNextPage: String,
    @ColumnInfo(name = "check_door_status_on_confirm") val checkDoorStatusOnConfirm: String,
    @ColumnInfo(name = "mandatory_door_closure_verification") val mandatoryDoorClosureVerification: String
)