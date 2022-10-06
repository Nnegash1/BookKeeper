package com.example.bookkeeper.presentation.view

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bookkeeper.data.data_source.entities.InvoiceDetails
import com.example.bookkeeper.databinding.FragmentDetailBinding
import com.example.bookkeeper.presentation.viewmodel.DetailPageViewModel
import com.example.bookkeeper.presentation.viewmodel.state.DetailState
import java.text.SimpleDateFormat
import java.util.*

class FragmentDetail : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val detailPageViewModel by viewModels<DetailPageViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDetailBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding) {
            datePickerActions.let {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    it?.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
                        val data = "$monthOfYear / $dayOfMonth / $year"
                        binding.issueDate.setText(data)
                    }
                }
            }
        }

        binding.submit.setOnClickListener {
            val invoiceDetail = getUserInput()
            if (invoiceDetail is InvoiceDetails)
            Log.d("TAG", "onViewCreated: ${invoiceDetail.issueDate}")
        }

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getUserInput(): Any {
        val invoiceDetail = try {
            val discount = binding.discountAmount.text.toString()
            val amount = if (discount == "") {
                0.0
            } else {
                discount.toDouble()
            }
            with(binding) {
                InvoiceDetails(
                    invoiceNumber = invoiceNumber.text.toString(),
                    issueDate = issueDate.text.toString(),
                    discount = amount
                )
            }
        } catch (message: NumberFormatException) {
            Toast.makeText(requireContext(), "Please insert a numeric value for discount", Toast.LENGTH_LONG).show()
        }

        return invoiceDetail
    }
}