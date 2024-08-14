package com.example.testgudang.data.repository

import androidx.lifecycle.LiveData
import com.example.testgudang.data.GudangDao
import com.example.testgudang.data.entity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GudangRepository(private val gudangDao: GudangDao) {

    suspend fun insertMasterBarang(masterBarang: MasterBarang) {
        withContext(Dispatchers.IO) {
            gudangDao.insertMasterBarang(masterBarang)
        }
    }

    suspend fun getAllMasterBarang(): LiveData<List<MasterBarang>> {
        return withContext(Dispatchers.IO) {
            gudangDao.getAllMasterBarang()
        }
    }

    suspend fun insertMasterBarangStock(masterBarangStock: MasterBarangStock) {
        gudangDao.insertMasterBarangStock(masterBarangStock)
    }

    suspend fun getAllMasterBarangStock(): List<MasterBarangStock> {
        return gudangDao.getAllMasterBarangStock()
    }

    suspend fun insertPermintaanBarang(permintaanBarang: PermintaanBarang) {
        gudangDao.insertPermintaanBarang(permintaanBarang)
    }

    suspend fun getAllPermintaanBarang(): List<PermintaanBarang> {
        return gudangDao.getAllPermintaanBarang()
    }

    suspend fun insertPermintaanBarangTracking(permintaanBarangTracking: PermintaanBarangTracking) {
        gudangDao.insertPermintaanBarangTracking(permintaanBarangTracking)
    }

    suspend fun getAllPermintaanBarangTracking(): List<PermintaanBarangTracking> {
        return gudangDao.getAllPermintaanBarangTracking()
    }
}