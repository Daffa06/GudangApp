package com.example.testgudang.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.testgudang.data.GudangDatabase
import com.example.testgudang.data.entity.*

class ListBarangViewModel(application: Application) : AndroidViewModel(application) {

    val allBarang: LiveData<List<MasterBarang>>

    init {
        val database = GudangDatabase.getDatabase(application)
        allBarang = database.gudangDao().getAllMasterBarang()
    }
}