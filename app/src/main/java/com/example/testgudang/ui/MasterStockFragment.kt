package com.example.testgudang.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testgudang.databinding.FragmentMasterStockBinding
import com.example.testgudang.data.entity.MasterBarangStock
import com.example.testgudang.viewmodel.GudangViewModel
import com.example.testgudang.viewmodel.GudangViewModelFactory

class MasterStockFragment : Fragment() {

    private var _binding: FragmentMasterStockBinding? = null
    private val binding get() = _binding!!
    private lateinit var gudangViewModel: GudangViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMasterStockBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gudangViewModel = ViewModelProvider(this, GudangViewModelFactory(requireActivity().application)).get(GudangViewModel::class.java)

        binding.btnSave.setOnClickListener {
            val kodeBarang = binding.etKodeBarang.text.toString()
            val quantity = binding.etQuantity.text.toString().toInt()

            val masterBarangStock = MasterBarangStock(
                kodeBarang = kodeBarang,
                quantity = quantity
            )

            gudangViewModel.insertMasterBarangStock(masterBarangStock)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}