package com.example.testgudang.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testgudang.R
import com.example.testgudang.adapter.BarangAdapter
import com.example.testgudang.viewmodel.ListBarangViewModel
import com.example.testgudang.databinding.ActivityListBarangBinding

class ListBarangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBarangBinding
    private val viewModel: ListBarangViewModel by viewModels()
    private lateinit var adapter: BarangAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBarangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = BarangAdapter()
        binding.recyclerViewBarang.apply {
            layoutManager = LinearLayoutManager(this@ListBarangActivity)
            adapter = this@ListBarangActivity.adapter
        }
    }

    private fun observeViewModel() {
        viewModel.allBarang.observe(this) { barangList ->
            adapter.submitList(barangList)
        }
    }
}