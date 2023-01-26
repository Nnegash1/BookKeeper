package com.example.bookkeeper.presentation.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.bookkeeper.data.data_source.entities.InvoiceDetails
import com.example.bookkeeper.databinding.FragmentDetailBinding
import com.example.bookkeeper.presentation.viewmodel.DetailPageViewModel
import com.example.bookkeeper.presentation.viewmodel.InvoiceDetailViewModel
import com.example.bookkeeper.presentation.viewmodel.InvoiceViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date
import java.util.Random
import javax.inject.Inject
import kotlin.math.abs

@AndroidEntryPoint
class FragmentDetail : Fragment() {

    @Inject
    lateinit var viewModelFactory: InvoiceViewModelFactory
    private lateinit var binding: FragmentDetailBinding
    private val detailPageViewModel by viewModels<DetailPageViewModel> { viewModelFactory }
    private val invoiceVM by activityViewModels<InvoiceDetailViewModel> { viewModelFactory }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = FragmentDetailBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            detailPageViewModel.detail.collect {
                with(binding) {
                    invoiceNumber.setText(it.invoiceDetail.invoiceNumber)
                    if (issueDate is TextView) issueDate.text = it.invoiceDetail.dueDate
                    discountAmount.setText(it.invoiceDetail.discount.toString())
                    referenceNumber.text = abs(Random().nextLong()).toString()
                }
                invoiceVM.detailUpdate(it.invoiceDetail)
            }
        }


        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            detailPageViewModel.checked.collect {
                binding.percent.isChecked = it
            }
        }

        binding.percent.setOnClickListener {
            binding.dollar.isChecked = false
            detailPageViewModel.isChecked(binding.percent.isChecked)
        }

        binding.dollar.setOnClickListener {
            binding.percent.isChecked = false
            detailPageViewModel.isChecked(binding.percent.isChecked)
        }

        binding.submit.setOnClickListener {
            val invoiceDetail = getUserInput()
            if (invoiceDetail is InvoiceDetails) {
                detailPageViewModel.updateDetail(invoiceDetail)
            }
            findNavController().popBackStack()
        }

        binding.backButton?.setOnClickListener {
            findNavController().popBackStack()
        }

        with(binding) {
            datePickerActions.let {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    it.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth ->
                        val month = monthOfYear + 1
                        val data = "$month / $dayOfMonth / $year"

                        Date()
                        with(binding) {
                            if (issueDate is TextView) issueDate.text = data
                        }
                    }
                }
            }
        }
    }

    private fun getUserInput(): Any {
        val invoiceDetail = try {
            val discount = binding.discountAmount.text.toString()
            val amount = if (discount == "") {
                0.0
            } else {
                if (binding.percent.isChecked) {
                    discount.toDouble()
                } else {
                    discount.toDouble()
                }
            }
            with(binding) {
                var data = ""
                if (issueDate is TextView) data = issueDate.text.toString()
                InvoiceDetails(
                    invoiceNumber = invoiceNumber.text.toString(),
                    dueDate = data,
                    discount = amount,
                )
            }
        } catch (message: NumberFormatException) {
            Toast.makeText(
                requireContext(), "Please insert a numeric value for discount", Toast.LENGTH_LONG
            ).show()
        }

        return invoiceDetail
    }
}