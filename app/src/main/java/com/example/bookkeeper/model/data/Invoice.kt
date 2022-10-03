package com.example.bookkeeper.model.data

import android.location.Address
import java.util.*

data class Invoice(
    val date: Date,
    val client : String,
    val invoice_id : Long = Random().nextLong(),
    val address : Address?,
    val item : List<Item>
)
