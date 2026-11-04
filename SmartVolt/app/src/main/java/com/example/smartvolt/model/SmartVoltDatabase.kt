package com.example.smartvolt.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.smartvolt.model.MarcaDao
import com.example.smartvolt.model.MarcaEntity

@Database(entities = [MarcaEntity::class], version = 1, exportSchema = false)
abstract class SmartVoltDatabase : RoomDatabase() {

    abstract fun marcaDao(): MarcaDao

    companion object {
        @Volatile
        private var INSTANCIA: SmartVoltDatabase? = null

        fun getInstance(context: Context): SmartVoltDatabase {
            return INSTANCIA ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    SmartVoltDatabase::class.java,
                    "smartvolt.db"
                ).build().also { INSTANCIA = it }
            }
        }
    }
}