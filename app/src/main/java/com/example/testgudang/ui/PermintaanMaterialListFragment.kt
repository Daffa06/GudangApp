package com.example.testgudang.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testgudang.databinding.FragmentPermintaanMaterialListBinding
import com.example.testgudang.viewmodel.GudangViewModel
import com.example.testgudang.viewmodel.GudangViewModelFactory

class PermintaanMaterialListFragment : Fragment() {

    private var _binding: FragmentPermintaanMaterialListBinding? = null
    private val binding get() = _binding!!
    private lateinit var gudangViewModel: GudangViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPermintaanMaterialListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gudangViewModel = ViewModelProvider(this, GudangViewModelFactory(requireActivity().application)).get(GudangViewModel::class.java)

        val adapter = PermintaanMaterialListAdapter()
        binding.rvPermintaanMaterialList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPermintaanMaterialList.adapter = adapter

        gudangViewModel.getAllPermintaanBarangAsync { permintaanBarangList ->
            permintaanBarangList?.let {
                adapter.submitList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}