package com.example.testgudang.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testgudang.data.entity.*

@Database(entities = [MasterBarang::class, MasterBarangStock::class, PermintaanBarang::class, PermintaanBarangTracking::class], version = 1)
abstract class GudangDatabase : RoomDatabase() {
    abstract fun gudangDao(): GudangDao

    companion object {
        @Volatile
        private var INSTANCE: GudangDatabase? = null

        fun getDatabase(context: Context): GudangDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GudangDatabase::class.java,
                    "gudang_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}