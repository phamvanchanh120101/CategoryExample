package com.example.categoryexample.data.model.api

data class WorkFlowRes(
    val enforceEmailDomain: Boolean,
    val enforceReturnToLoanStation: Boolean,
    val despatchForceRequireEmail: Boolean,
    val deliveryForceRequireEmail: Boolean,
    val collectorMustUseRecipientEmail: Boolean,
    val defaultLoanPeriod: Double,
    val sendReminderToLoanUserOverdueBefore: Double,
    val despatchDefaultOverdue: Double,
    val deliveryOverdue: Double,
    val autoSerialNumber: Boolean,
    val noLoanLimit: Boolean,
    val noPermanentIssueLimit: Boolean,
    val enableScanningSerialNumberPage: Boolean,
    val lastSaved: String?,
    val emailVerificationEquipmentLoan: Boolean,
    val emailVerificationEquipmentPermanentIssue: Boolean,
    val emailVerificationEquipmentReturn: Boolean,
    val emailVerificationDespatch: Boolean,
    val emailVerificationInternalDelivery: Boolean
)