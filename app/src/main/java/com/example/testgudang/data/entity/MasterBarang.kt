package com.example.testgudang.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "master_barang")
data class MasterBarang(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "kode_barang") val kodeBarang: String,
    @ColumnInfo(name = "nama_barang") val namaBarang: String,
    @ColumnInfo(name = "keterangan") val keterangan: String,
    @ColumnInfo(name = "satuan") val satuan: String
)