package com.example.twowaydemo1

import dagger.Component

@Component(modules = [MemoryCardModule::class,NickelBatteryModel::class])
interface SmartPhoneComponent {
    fun getSmartPhone(): SmartPhone
}