package com.example.twowaydemo1.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ConverterDao {
    @Insert
    suspend fun insertResult(result: ConversionReults)

    @Delete
    suspend fun deleteResult(result: ConversionReults)

    @Query("DELETE FROM result_table")
    suspend fun deleteAll()

    // room library use coroutine in select query so no need to use suspend

    @Query("select * from result_table")
    fun getResult(): Flow<List<ConversionReults>>

}