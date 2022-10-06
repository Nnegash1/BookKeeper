package com.example.bookkeeper.data.data_source.entities

data class Invoice(
    val client: Client,
    val item: List<Item>,
    val invoiceDetails: InvoiceDetails
)
