package com.example.testgudang.adapter

import com.example.testgudang.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testgudang.data.entity.*

class MasterBarangAdapter : RecyclerView.Adapter<MasterBarangAdapter.MasterBarangViewHolder>() {

    private var barangList = emptyList<MasterBarang>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasterBarangViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_master_material, parent, false) as View
        return MasterBarangViewHolder(view)
    }

    override fun onBindViewHolder(holder: MasterBarangViewHolder, position: Int) {
        val currentItem = barangList[position]
        holder.itemView.findViewById<TextView>(R.id.rvBarang).text = currentItem.namaBarang
        // Set other item views
    }

    override fun getItemCount(): Int {
        return barangList.size
    }

    fun setData(barang: List<MasterBarang>) {
        this.barangList = barang
        notifyDataSetChanged()
    }

    class MasterBarangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
