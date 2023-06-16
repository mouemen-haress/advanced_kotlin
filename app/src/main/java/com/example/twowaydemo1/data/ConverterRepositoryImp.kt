package com.example.twowaydemo1.data

import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImp(private val dao: ConverterDao) : ConverterRepository {
    override suspend fun insertResult(result: ConversionReults) {
        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionReults) {
        dao.deleteResult(result)

    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override fun getResult(): Flow<List<ConversionReults>> {
        return dao.getResult()
    }
}