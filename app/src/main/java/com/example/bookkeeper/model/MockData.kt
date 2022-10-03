package com.example.bookkeeper.model

import android.location.Address
import com.example.bookkeeper.model.data.Invoice
import com.example.bookkeeper.model.data.InvoiceData
import com.example.bookkeeper.model.data.Item
import java.util.*

val mock_data = InvoiceData(
    mutableListOf(
        Invoice(

            date = Date(),
            item = listOf(
                Item(
                    "1200R20 668 22PR",
                    "TRIANGLE",
                    "CHINA",
                    "40111000",
                    "TIRE",
                    12.0,
                    12.0,
                    12.0,
                    12.0
                )
            ),
            client = "Nahom Negash",
            address = Address(Locale("Amharic", "Ethiopia"))
        ),
        Invoice(

            date = Date(),
            item = listOf(
                Item(
                    "1200R20 668 22PR",
                    "TRIANGLE",
                    "CHINA",
                    "40111000",
                    "TIRE",
                    12.0,
                    12.0,
                    12.0,
                    12.0
                )
            ),
            client = "Nahom Negash",
            address = Address(Locale("Amharic", "Ethiopia"))
        ),
        Invoice(

            date = Date(),
            item = listOf(
                Item(
                    "1200R20 668 22PR",
                    "TRIANGLE",
                    "CHINA",
                    "40111000",
                    "TIRE",
                    12.0,
                    12.0,
                    12.0,
                    12.0
                )
            ),
            client = "Nahom Negash",
            address = Address(Locale("Amharic", "Ethiopia"))
        ),
        Invoice(

            date = Date(),
            item = listOf(
                Item(
                    "1200R20 668 22PR",
                    "TRIANGLE",
                    "CHINA",
                    "40111000",
                    "TIRE",
                    12.0,
                    12.0,
                    12.0,
                    12.0
                )
            ),
            client = "Nahom Negash",
            address = Address(Locale("Amharic", "Ethiopia"))
        )
    )
)

