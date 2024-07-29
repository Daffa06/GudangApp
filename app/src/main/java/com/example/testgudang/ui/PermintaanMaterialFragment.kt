package com.example.testgudang.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testgudang.databinding.FragmentPermintaanMaterialBinding
import com.example.testgudang.data.entity.PermintaanBarang
import com.example.testgudang.viewmodel.GudangViewModel
import com.example.testgudang.viewmodel.GudangViewModelFactory

class PermintaanMaterialFragment : Fragment() {

    private var _binding: FragmentPermintaanMaterialBinding? = null
    private val binding get() = _binding!!
    private lateinit var gudangViewModel: GudangViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPermintaanMaterialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gudangViewModel = ViewModelProvider(this, GudangViewModelFactory(requireActivity().application)).get(GudangViewModel::class.java)

        binding.btnSave.setOnClickListener {
            val pemohon = binding.etPemohon.text.toString()
            val kodePermintaan = binding.etKodePermintaan.text.toString()
            val kodeBarang = binding.etKodeBarang.text.toString()
            val keterangan = binding.etKeterangan.text.toString()
            val quantity = binding.etQuantity.text.toString().toInt()

            val permintaanBarang = PermintaanBarang(
                pemohon = pemohon,
                kodePermintaan = kodePermintaan,
                kodeBarang = kodeBarang,
                keterangan = keterangan,
                quantity = quantity
            )

            gudangViewModel.insertPermintaanBarang(permintaanBarang)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}