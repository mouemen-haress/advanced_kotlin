package com.example.twowaydemo1.db

import androidx.room.TypeConverter
import com.example.twowaydemo1.models.Source

class Converter {

    @TypeConverter
    fun fromSource(source: Source): String? {
            return source.name

    }

    @TypeConverter
    fun ToSource(name: String): Source {
        return Source(name = name, id = name)
    }
}