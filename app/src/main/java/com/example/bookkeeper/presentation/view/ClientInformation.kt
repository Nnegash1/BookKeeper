package com.example.bookkeeper.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bookkeeper.R
import com.example.bookkeeper.databinding.FragmentClientInformationBinding

class ClientInformation : Fragment() {

    lateinit var binding: FragmentClientInformationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = FragmentClientInformationBinding.inflate(layoutInflater, container, false)
        return view.root
    }


}