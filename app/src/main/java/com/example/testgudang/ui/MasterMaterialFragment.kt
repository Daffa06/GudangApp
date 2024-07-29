package com.example.testgudang.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.ViewModelProvider
import com.example.testgudang.databinding.FragmentMasterMaterialBinding
import com.example.testgudang.data.entity.MasterBarang
import com.example.testgudang.viewmodel.GudangViewModel
import com.example.testgudang.viewmodel.GudangViewModelFactory
import kotlinx.coroutines.launch

class MasterMaterialFragment : Fragment() {

    private var _binding: FragmentMasterMaterialBinding? = null
    private val binding get() = _binding!!
    private lateinit var gudangViewModel: GudangViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMasterMaterialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gudangViewModel = ViewModelProvider(this, GudangViewModelFactory(requireActivity().application)).get(GudangViewModel::class.java)

        binding.btnSave.setOnClickListener {
            val kodeBarang = binding.etKodeBarang.text.toString()
            val namaBarang = binding.etNamaBarang.text.toString()
            val keterangan = binding.etKeterangan.text.toString()
            val satuan = binding.etSatuan.text.toString()

            val masterBarang = MasterBarang(
                kodeBarang = kodeBarang,
                namaBarang = namaBarang,
                keterangan = keterangan,
                satuan = satuan
            )

            // Menggunakan lifecycleScope untuk menjalankan coroutine
            viewLifecycleOwner.lifecycleScope.launch {
                gudangViewModel.insertMasterBarang(masterBarang)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}