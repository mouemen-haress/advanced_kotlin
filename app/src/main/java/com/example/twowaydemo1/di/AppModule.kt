package com.example.twowaydemo1.di

import android.app.Application
import androidx.room.Insert
import androidx.room.Room
import com.example.twowaydemo1.data.ConverterDataBase
import com.example.twowaydemo1.data.ConverterRepository
import com.example.twowaydemo1.data.ConverterRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConverterDataBase(app: Application): ConverterDataBase {
        return Room.databaseBuilder(
            app, ConverterDataBase::class.java,
            "converter_data_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideConverterRepository(db: ConverterDataBase): ConverterRepository {
        return ConverterRepositoryImp(db.converterDAO)
    }
}