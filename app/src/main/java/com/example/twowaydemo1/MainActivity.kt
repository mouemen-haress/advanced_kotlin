package com.example.twowaydemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.internal.DaggerCollections
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var smartPhone: SmartPhone

    @Inject
    lateinit var memoryCard: MemoryCard
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

//        DaggerSmartPhoneComponent.create().inject(this)
//        smartPhone.makeACallWithRecording()
        (application as SmartPhoneApplication).smartPhoneComponent
            .inject(this)
        smartPhone.makeACallWithRecording()
//        val smartPhone = SmartPhone(
//            Battery(),
//            SIMCard(ServiceProvider()),
//            MemoryCard()
//        )
//            .makeACallWithRecording()


        //////////////////////
        // add singelton annotation
    }
}
