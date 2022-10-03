package com.example.bookkeeper.ui.main

import android.location.Address
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bookkeeper.databinding.FragmentInsertItemBinding
import com.example.bookkeeper.model.data.Invoice
import com.example.bookkeeper.model.data.Item
import com.example.bookkeeper.viewmodel.InvoiceViewModel
import java.util.*


class FragmentInvoiceDetail : Fragment() {

    lateinit var binding: FragmentInsertItemBinding
    private val vm: InvoiceViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentInsertItemBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val invoice = Invoice(
            client = "Eyob",
            date = Date(), // Detail screen
            address = Address(Locale("Amharic", "Ethiopia")), // detail screen
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
            )
        )
    }

}