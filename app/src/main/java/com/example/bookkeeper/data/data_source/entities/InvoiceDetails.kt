package com.example.bookkeeper.data.data_source.entities

import java.util.Date
import java.util.Random


data class InvoiceDetails(
    val invoiceNumber: String = "",
    val dueDate : String = "",
    val issueDate: String = Date().toString(),
    val discount: Double = 0.0,
    val percentDiscount: Double = 0.0,
    val referenceNo: Long = Random().nextLong()
)
