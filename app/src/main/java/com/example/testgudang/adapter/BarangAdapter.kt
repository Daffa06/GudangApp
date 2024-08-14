package com.example.testgudang.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testgudang.R
import com.example.testgudang.data.entity.*

class BarangAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<BarangAdapter.BarangViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var barangList = emptyList<MasterBarang>()

    inner class BarangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val barangItemView: TextView = itemView.findViewById(R.id.textViewBarang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangViewHolder {
        val itemView = inflater.inflate(R.layout.fragment_master_material, parent, false)
        return BarangViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        val current = barangList[position]
        holder.barangItemView.text = current.namaBarang
    }

    internal fun setBarangList(barang: List<MasterBarang>) {
        this.barangList = barang
        notifyDataSetChanged()
    }

    override fun getItemCount() = barangList.size
}
