package com.example.bookkeeper.data.data_source.local

import com.example.bookkeeper.data.data_source.entities.*
import java.util.*


val itemContainer: MutableList<Item> = mutableListOf()

val mock_data = InvoiceData(
    mutableListOf(
        Invoice(

            item = listOf(
                Item(
                    "1200R20 668 22PR",
                    "TRIANGLE",
                    "CHINA",
                    "40111000",
                    "TIRE",
                    12,
                    12.0,
                    12.0,
                )
            ),
            client = Client(
                "Negash",
                phoneNumber = "000-000-0000",
                email = "nahom@gmail.com",
                country = "Ethiopia",
                street = "Addis Ababa",
                apt = "123",
                postCode = "20866",
                city = null,
                province = null
            ),
            invoiceDetails = InvoiceDetails(
                invoiceNumber = Random().nextLong().toString(),
                issueDate = Date().toString()
            )
        ),
        Invoice(
            item = listOf(
                Item(
                    "1200R20 668 22PR",
                    "TRIANGLE",
                    "CHINA",
                    "40111000",
                    "TIRE",
                    12,
                    12.0,
                    12.0,
                )
            ),
            client = Client(
                "Eyob",
                phoneNumber = "000-000-0000",
                email = "nahom@gmail.com",
                country = "Ethiopia",
                street = "Addis Ababa",
                apt = "123",
                postCode = "20866",
                city = null,
                province = null
            ),
            invoiceDetails = InvoiceDetails(
                invoiceNumber = Random().nextLong().toString(),
                issueDate = Date().toString()
            )
        ),
        Invoice(
            item = listOf(
                Item(
                    "1200R20 668 22PR",
                    "TRIANGLE",
                    "CHINA",
                    "40111000",
                    "TIRE",
                    12,
                    12.0,
                    12.0,
                )
            ),
            client = Client(
                "Kifle",
                phoneNumber = "000-000-0000",
                email = "nahom@gmail.com",
                country = "Ethiopia",
                street = "Addis Ababa",
                apt = "123",
                postCode = "20866",
                city = null,
                province = null
            ),
            invoiceDetails = InvoiceDetails(
                invoiceNumber = Random().nextLong().toString(),
                issueDate = Date().toString()
            )
        ),
        Invoice(

            item = listOf(
                Item(
                    "1200R20 668 22PR",
                    "TRIANGLE",
                    "CHINA",
                    "40111000",
                    "TIRE",
                    12,
                    12.0,
                    12.0,
                )
            ),
            client = Client(
                "Nahom",
                phoneNumber = "000-000-0000",
                email = "nahom@gmail.com",
                country = "Ethiopia",
                street = "Addis Ababa",
                apt = "123",
                postCode = "20866",
                city = null,
                province = null
            ),
            invoiceDetails = InvoiceDetails(
                invoiceNumber = Random().nextLong().toString(),
                issueDate = Date().toString()

            )
        ),
        Invoice(

            item = listOf(
                Item(
                    "1200R20 668 22PR",
                    "TRIANGLE",
                    "CHINA",
                    "40111000",
                    "TIRE",
                    12,
                    12.0,
                    12.0,
                )
            ),
            client = Client(
                "Negash",
                phoneNumber = "000-000-0000",
                email = "nahom@gmail.com",
                country = "Ethiopia",
                street = "Addis Ababa",
                apt = "123",
                postCode = "20866",
                city = null,
                province = null
            ),
            invoiceDetails = InvoiceDetails(
                invoiceNumber = Random().nextLong().toString(),
                issueDate = Date().toString()
            )
        ),
        Invoice(
            item = listOf(
                Item(
                    "1200R20 668 22PR",
                    "TRIANGLE",
                    "CHINA",
                    "40111000",
                    "TIRE",
                    12,
                    12.0,
                    12.0,
                )
            ),
            client = Client(
                "Eyob",
                phoneNumber = "000-000-0000",
                email = "nahom@gmail.com",
                country = "Ethiopia",
                street = "Addis Ababa",
                apt = "123",
                postCode = "20866",
                city = null,
                province = null
            ),
            invoiceDetails = InvoiceDetails(
                invoiceNumber = Random().nextLong().toString(),
                issueDate = Date().toString()
            )
        ),
        Invoice(
            item = listOf(
                Item(
                    "1200R20 668 22PR",
                    "TRIANGLE",
                    "CHINA",
                    "40111000",
                    "TIRE",
                    12,
                    12.0,
                    12.0,
                )
            ),
            client = Client(
                "Kifle",
                phoneNumber = "000-000-0000",
                email = "nahom@gmail.com",
                country = "Ethiopia",
                street = "Addis Ababa",
                apt = "123",
                postCode = "20866",
                city = null,
                province = null
            ),
            invoiceDetails = InvoiceDetails(
                invoiceNumber = Random().nextLong().toString(),
                issueDate = Date().toString()
            )
        ),
        Invoice(

            item = listOf(
                Item(
                    "1200R20 668 22PR",
                    "TRIANGLE",
                    "CHINA",
                    "40111000",
                    "TIRE",
                    12,
                    12.0,
                    12.0,
                )
            ),
            client = Client(
                "Nahom",
                phoneNumber = "000-000-0000",
                email = "nahom@gmail.com",
                country = "Ethiopia",
                street = "Addis Ababa",
                apt = "123",
                postCode = "20866",
                city = null,
                province = null
            ),
            invoiceDetails = InvoiceDetails(
                invoiceNumber = Random().nextLong().toString(),
                issueDate = Date().toString()

            )
        )
    )
)
