package com.example.twowaydemo1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ConversionReults::class], version = 1)
abstract class ConverterDataBase : RoomDatabase() {

    abstract val converterDAO: ConversionDao

    companion object {
        @Volatile
        private var INSTANCE: ConverterDataBase? = null
        fun getInstance(context: Context): ConverterDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ConverterDataBase::class.java,
                        "converter_data_database"
                    ).build()
                }
                return instance
            }
        }

    }
}
