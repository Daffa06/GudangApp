package com.example.testgudang.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testgudang.R
import com.example.testgudang.data.entity.*

class BarangAdapter : ListAdapter<MasterBarang, BarangAdapter.BarangViewHolder>(BarangDiffCallback()) {

    inner class BarangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val barangItemView: TextView = itemView.findViewById(R.id.textViewBarang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_master_material, parent, false)
        return BarangViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        val current = getItem(position)
        holder.barangItemView.text = current.namaBarang
    }

    class BarangDiffCallback : DiffUtil.ItemCallback<MasterBarang>() {
        override fun areItemsTheSame(oldItem: MasterBarang, newItem: MasterBarang): Boolean {
            // Perbandingan berdasarkan ID atau atribut unik
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MasterBarang, newItem: MasterBarang): Boolean {
            // Perbandingan konten item
            return oldItem == newItem
        }
    }
}
