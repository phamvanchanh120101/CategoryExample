package com.example.categoryexample.data.local.mapper

import com.example.categoryexample.data.model.api.KioskConfigRes
import com.example.categoryexample.data.model.entity.KioskConfigEntity
import com.example.categoryexample.domain.model.KioskConfigModel

fun KioskConfigEntity.toDomain(): KioskConfigModel {
    return KioskConfigModel(
        homeScreenLogo = this.homeScreenLogo,
        subScreenLogo = this.subScreenLogo,
        homeScreenBackground = this.homeScreenBackground,
        subScreenBackground = this.subScreenBackground,
        ownerText = this.ownerText,
        ownerImage = this.ownerImage,
        emailDomain = this.emailDomain,
        administratorSupportEmail = this.administratorSupportEmail,
        orderCategoryOnKiosk = this.orderCategoryOnKiosk,
        orderModelOnKiosk = this.orderModelOnKiosk,
        enableInternalDelivery = this.enableInternalDelivery,
        autoTriggerDelay = this.autoTriggerDelay,
        autoNextPage = this.autoNextPage,
        checkDoorStatusOnConfirm = this.checkDoorStatusOnConfirm,
        mandatoryDoorClosureVerification = this.mandatoryDoorClosureVerification
    )
}

fun KioskConfigModel.toEntity(): KioskConfigEntity {
    return KioskConfigEntity(
        homeScreenLogo = this.homeScreenLogo,
        subScreenLogo = this.subScreenLogo,
        homeScreenBackground = this.homeScreenBackground,
        subScreenBackground = this.subScreenBackground,
        ownerText = this.ownerText,
        ownerImage = this.ownerImage,
        emailDomain = this.emailDomain,
        administratorSupportEmail = this.administratorSupportEmail,
        orderCategoryOnKiosk = this.orderCategoryOnKiosk,
        orderModelOnKiosk = this.orderModelOnKiosk,
        enableInternalDelivery = this.enableInternalDelivery,
        autoTriggerDelay = this.autoTriggerDelay,
        autoNextPage = this.autoNextPage,
        checkDoorStatusOnConfirm = this.checkDoorStatusOnConfirm,
        mandatoryDoorClosureVerification = this.mandatoryDoorClosureVerification
    )
}
fun KioskConfigRes.toEntity(): KioskConfigEntity {
    return KioskConfigEntity(
        homeScreenLogo = this.home_screen_logo,
        subScreenLogo = this.sub_screen_logo,
        homeScreenBackground = this.home_screen_background,
        subScreenBackground = this.sub_screen_background,
        ownerText = this.owner_text,
        ownerImage = this.owner_image,
        emailDomain = this.email_domain,
        administratorSupportEmail = this.administrator_support_email,
        orderCategoryOnKiosk = this.order_category_on_kiosk,
        orderModelOnKiosk = this.order_model_on_kiosk,
        enableInternalDelivery = this.enable_internal_delivery,
        autoTriggerDelay = this.auto_trigger_delay,
        autoNextPage = this.auto_next_page,
        checkDoorStatusOnConfirm = this.check_door_status_on_confirm,
        mandatoryDoorClosureVerification = this.mandatory_door_closure_verification
    )
}

