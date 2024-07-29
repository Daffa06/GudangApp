package com.example.testgudang.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "master_barang_stock")
data class MasterBarangStock(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "kode_barang") val kodeBarang: String,
    @ColumnInfo(name = "quantity") val quantity: Int
)