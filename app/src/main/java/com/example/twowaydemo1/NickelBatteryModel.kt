package com.example.twowaydemo1

import dagger.Binds
import dagger.Module
import dagger.Provides

//@Module
//class NickelBatteryModel {
//
//    @Provides
//    fun provideNickelBattery(nickel: NickelBattery): Battery {
//        return nickel
//    }
//}

//option 2
@Module
abstract class NickelBatteryModel {
    @Binds
   abstract fun provideNickelBattery(nickel: NickelBattery): Battery
}