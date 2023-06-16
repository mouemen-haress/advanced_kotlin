package com.example.twowaydemo1.data


import kotlinx.coroutines.flow.Flow

interface ConverterRepository   {

    suspend fun insertResult(result: ConversionReults)

    suspend fun deleteResult(result: ConversionReults)

    suspend fun deleteAll()

    fun getResult(): Flow<List<ConversionReults>>
}