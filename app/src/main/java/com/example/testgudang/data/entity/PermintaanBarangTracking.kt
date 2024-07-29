package com.example.testgudang.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "permintaan_barang_tracking")
data class PermintaanBarangTracking(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "kode_permintaan") val kodePermintaan: String,
    @ColumnInfo(name = "status") val status: Int,
    @ColumnInfo(name = "tanggal") val tanggal: String
)