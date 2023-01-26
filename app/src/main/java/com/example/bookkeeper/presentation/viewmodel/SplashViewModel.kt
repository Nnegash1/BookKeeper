package com.example.bookkeeper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val visibility = MutableStateFlow(true)
    val _visibility get() = visibility.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1000)
            visibility.value = false
        }
    }
}