package com.example.bookkeeper.data.data_source.entities

import java.util.*


data class InvoiceDetails(
    val invoiceNumber: String = "",
    val issueDate: String = "",
    val discount: Double = 0.0,
    val percentDiscount: Double = 0.0,
    val referenceNo: Long = Random().nextLong()
)
