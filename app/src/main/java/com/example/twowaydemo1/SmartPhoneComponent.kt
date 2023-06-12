package com.example.twowaydemo1

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardModule::class, NickelBatteryModel::class])
interface SmartPhoneComponent {
    fun inject(mainActivity: MainActivity)
}
