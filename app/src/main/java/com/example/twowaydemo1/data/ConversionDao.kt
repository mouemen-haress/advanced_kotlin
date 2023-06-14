package com.example.twowaydemo1.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.concurrent.Flow


@Dao
interface ConversionDao {

    @Insert
    suspend fun insertResult(result: ConversionReults)

    @Delete
    suspend fun deleteResult(result: ConversionReults)

    @Query("DELETE FROM result_table")
    suspend fun deleteAll()

    fun getResult():Flow

}