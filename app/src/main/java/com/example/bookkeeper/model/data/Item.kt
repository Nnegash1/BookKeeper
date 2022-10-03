package com.example.bookkeeper.model.data

data class Item(
    val description: String,
    val brand: String,
    val origin: String,
    val hs_code: String,
    val item: String,
    val qty: Double,
    val unit_price: Double,
    val discount: Double,
    val fob_price: Double
)
