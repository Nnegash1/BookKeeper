package com.example.bookkeeper.data.data_source.entities


data class Client(
    val name: String = "",
    val phoneNumber: String? = null,
    val email: String? = null,
    val country: String? = null,
    val street: String? = null,
    val apt: String? = null,
    val postCode: String? = null,
    val city: String? = null,
    val province: String? = null,
)
