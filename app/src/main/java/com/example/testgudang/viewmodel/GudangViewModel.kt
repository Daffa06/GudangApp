package com.example.testgudang.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.testgudang.data.GudangDatabase
import com.example.testgudang.data.entity.*
import com.example.testgudang.data.repository.GudangRepository
import kotlinx.coroutines.launch

class GudangViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GudangRepository

    init {
        val gudangDao = GudangDatabase.getDatabase(application).gudangDao()
        repository = GudangRepository(gudangDao)
    }

    // Master Barang
    fun insertMasterBarang(masterBarang: MasterBarang) = viewModelScope.launch {
        repository.insertMasterBarang(masterBarang)
    }

    fun getAllMasterBarang(): List<MasterBarang> {
        var data: List<MasterBarang> = emptyList()
        viewModelScope.launch {
            data = repository.getAllMasterBarang()
        }
        return data
    }

    // Master Barang Stock
    fun insertMasterBarangStock(masterBarangStock: MasterBarangStock) = viewModelScope.launch {
        repository.insertMasterBarangStock(masterBarangStock)
    }

    fun getAllMasterBarangStock(): List<MasterBarangStock> {
        var data: List<MasterBarangStock> = emptyList()
        viewModelScope.launch {
            data = repository.getAllMasterBarangStock()
        }
        return data
    }

    // Permintaan Barang
    fun insertPermintaanBarang(permintaanBarang: PermintaanBarang) = viewModelScope.launch {
        repository.insertPermintaanBarang(permintaanBarang)
    }

    fun getAllPermintaanBarang(): List<PermintaanBarang> {
        var data: List<PermintaanBarang> = emptyList()
        viewModelScope.launch {
            data = repository.getAllPermintaanBarang()
        }
        return data
    }

    fun getAllPermintaanBarangAsync(callback: (List<PermintaanBarang>) -> Unit) {
        viewModelScope.launch {
            val permintaanBarangList = repository.getAllPermintaanBarang()
            callback(permintaanBarangList)
        }
    }

    // Permintaan Barang Tracking
    fun insertPermintaanBarangTracking(permintaanBarangTracking: PermintaanBarangTracking) = viewModelScope.launch {
        repository.insertPermintaanBarangTracking(permintaanBarangTracking)
    }

    fun getAllPermintaanBarangTracking(): List<PermintaanBarangTracking> {
        var data: List<PermintaanBarangTracking> = emptyList()
        viewModelScope.launch {
            data = repository.getAllPermintaanBarangTracking()
        }
        return data
    }
}