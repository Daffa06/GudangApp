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
import com.example.testgudang.adapter.BarangAdapter
import kotlinx.coroutines.launch
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

class MasterMaterialFragment : Fragment() {

    private var _binding: FragmentMasterMaterialBinding? = null
    private val binding get() = _binding!!
    private lateinit var gudangViewModel: GudangViewModel
    private lateinit var barangAdapter: BarangAdapter

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

        // Setup RecyclerView
        setupRecyclerView()

        // Set up FloatingActionButton
        setupFabListener()

        binding.btnSave.setOnClickListener {
            val kodeBarang = binding.etKodeBarang.text.toString()
            val namaBarang = binding.etNamaBarang.text.toString()
            val keterangan = binding.etKeterangan.text.toString()
            val satuan = binding.etSatuan.text.toString()

            // Validasi input
            if (kodeBarang.isNotEmpty() && namaBarang.isNotEmpty() && keterangan.isNotEmpty() && satuan.isNotEmpty()) {
                val masterBarang = MasterBarang(
                    kodeBarang = kodeBarang,
                    namaBarang = namaBarang,
                    keterangan = keterangan,
                    satuan = satuan
                )

                // Menggunakan lifecycleScope untuk menjalankan coroutine
                viewLifecycleOwner.lifecycleScope.launch {
                    try {
                        gudangViewModel.insertMasterBarang(masterBarang)
                        Log.d("Save", "Data berhasil disimpan: $masterBarang")
                        // Bersihkan form input setelah berhasil menyimpan
                        clearForm()
                        // Sembunyikan form dan tampilkan kembali RecyclerView
                        binding.formLayout.visibility = View.GONE
                        binding.recyclerViewBarang.visibility = View.VISIBLE
                        // Update UI atau beri pesan bahwa data berhasil disimpan
                    } catch (e: Exception) {
                        Log.e("Save", "Error saat menyimpan data", e)
                    }
                }
            } else {
                Log.w("Save", "Input tidak valid")
                // Beri pesan kepada pengguna bahwa input tidak valid
            }
        }
    }

    private fun setupRecyclerView() {
        barangAdapter = BarangAdapter()
        binding.recyclerViewBarang.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = barangAdapter
        }

        // Observe LiveData dari ViewModel untuk memperbarui daftar barang
        gudangViewModel.getAllMasterBarang().observe(viewLifecycleOwner, { barangList ->
            barangList?.let {
                barangAdapter.submitList(it)
            }
        })
    }

    private fun setupFabListener() {
        binding.fabAdd.setOnClickListener {
            // Ubah visibilitas formLayout dan RecyclerView
            if (binding.formLayout.visibility == View.GONE) {
                binding.formLayout.visibility = View.VISIBLE
                binding.recyclerViewBarang.visibility = View.GONE
                binding.etKodeBarang.requestFocus()
            } else {
                binding.formLayout.visibility = View.GONE
                binding.recyclerViewBarang.visibility = View.VISIBLE
            }
        }
    }

    private fun clearForm() {
        binding.etKodeBarang.text.clear()
        binding.etNamaBarang.text.clear()
        binding.etKeterangan.text.clear()
        binding.etSatuan.text.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}