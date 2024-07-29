package com.example.testgudang.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "permintaan_barang")
data class PermintaanBarang(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "pemohon") val pemohon: String,
    @ColumnInfo(name = "kode_permintaan") val kodePermintaan: String,
    @ColumnInfo(name = "kode_barang") val kodeBarang: String,
    @ColumnInfo(name = "keterangan") val keterangan: String,
    @ColumnInfo(name = "quantity") val quantity: Int
)