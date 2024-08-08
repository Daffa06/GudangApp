package com.example.testgudang.data.repository

import androidx.lifecycle.LiveData
import com.example.testgudang.data.GudangDao
import com.example.testgudang.data.GudangDatabase
import com.example.testgudang.data.entity.*
import com.example.testgudang.data.repository.GudangRepository

class MasterBarangRepository(private val gudangDao: GudangDao) {
    fun getAllBarang(): LiveData<List<MasterBarang>> = gudangDao.getAllMasterBarang() as LiveData<List<MasterBarang>>
}