package com.example.twowaydemo1

import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule(val memorySize: Int) {

    @Provides
    fun provideMemoryCard(): MemoryCard {
        return MemoryCard()
    }
}