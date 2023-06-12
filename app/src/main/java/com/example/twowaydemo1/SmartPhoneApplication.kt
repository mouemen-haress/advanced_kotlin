package com.example.twowaydemo1

import android.app.Application
import javax.inject.Inject

class SmartPhoneApplication : Application() {

    @Inject
    lateinit var smartPhoneComponent: SmartPhoneComponent

    override fun onCreate() {
        smartPhoneComponent = initDagger()
        super.onCreate()

    }

    private fun initDagger(): SmartPhoneComponent {
        return DaggerSmartPhoneComponent.builder().memoryCardModule(MemoryCardModule(4)).build()

    }
}