package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bookkeeper.domain.repository.InvoiceRepository
import javax.inject.Inject


class InvoiceViewModelFactory @Inject constructor(private val repo: InvoiceRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass.simpleName) {
            ClientViewModel::class.java.simpleName -> {
                @Suppress("UNCHECKED_CAST")
                ClientViewModel(repo) as T
            }
            DetailPageViewModel::class.java.simpleName -> {
                @Suppress("UNCHECKED_CAST")
                DetailPageViewModel(repo) as T
            }
            InvoiceDetailViewModel::class.java.simpleName -> {
                @Suppress("UNCHECKED_CAST")
                InvoiceDetailViewModel(repo) as T
            }
            InvoiceViewModel::class.java.simpleName -> {
                @Suppress("UNCHECKED_CAST")
                InvoiceViewModel(repo) as T
            }
            ItemPageViewModel::class.java.simpleName -> {
                @Suppress("UNCHECKED_CAST")
                ItemPageViewModel(repo) as T
            }
            ClientInformationViewModel::class.java.simpleName -> {
                @Suppress("UNCHECKED_CAST")
                ClientInformationViewModel(repo) as T
            }
            else -> {
                throw IllegalArgumentException("ViewModel Not compatible")
            }
        }
    }
}