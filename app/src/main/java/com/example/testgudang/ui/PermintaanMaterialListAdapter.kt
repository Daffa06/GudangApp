package com.example.testgudang.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testgudang.databinding.ItemPermintaanMaterialBinding
import com.example.testgudang.data.entity.PermintaanBarang

class PermintaanMaterialListAdapter :
    ListAdapter<PermintaanBarang, PermintaanMaterialListAdapter.PermintaanMaterialViewHolder>(PermintaanMaterialDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PermintaanMaterialViewHolder {
        val binding = ItemPermintaanMaterialBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PermintaanMaterialViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PermintaanMaterialViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class PermintaanMaterialViewHolder(private val binding: ItemPermintaanMaterialBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(permintaanBarang: PermintaanBarang) {
            binding.apply {
                tvKodePermintaan.text = permintaanBarang.kodePermintaan
                tvPemohon.text = permintaanBarang.pemohon
                tvKodeBarang.text = permintaanBarang.kodeBarang
                tvKeterangan.text = permintaanBarang.keterangan
                tvQuantity.text = permintaanBarang.quantity.toString()
            }
        }
    }

    class PermintaanMaterialDiffCallback : DiffUtil.ItemCallback<PermintaanBarang>() {
        override fun areItemsTheSame(oldItem: PermintaanBarang, newItem: PermintaanBarang): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PermintaanBarang, newItem: PermintaanBarang): Boolean {
            return oldItem == newItem
        }
    }
}