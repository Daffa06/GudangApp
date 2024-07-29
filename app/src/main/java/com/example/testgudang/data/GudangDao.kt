package com.example.testgudang.data

import androidx.room.*
import com.example.testgudang.data.entity.*

@Dao
interface GudangDao {
    // Master Barang
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMasterBarang(masterBarang: MasterBarang): Long

    @Query("SELECT * FROM master_barang")
    fun getAllMasterBarang(): List<MasterBarang>

    // Master Barang Stock
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMasterBarangStock(masterBarangStock: MasterBarangStock): Long

    @Query("SELECT * FROM master_barang_stock")
    fun getAllMasterBarangStock(): List<MasterBarangStock>

    // Permintaan Barang
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPermintaanBarang(permintaanBarang: PermintaanBarang): Long

    @Query("SELECT * FROM permintaan_barang")
    fun getAllPermintaanBarang(): List<PermintaanBarang>

    // Permintaan Barang Tracking
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPermintaanBarangTracking(permintaanBarangTracking: PermintaanBarangTracking): Long

    @Query("SELECT * FROM permintaan_barang_tracking")
    fun getAllPermintaanBarangTracking(): List<PermintaanBarangTracking>
}