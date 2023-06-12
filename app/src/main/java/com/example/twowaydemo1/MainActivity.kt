package com.example.twowaydemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.internal.DaggerCollections
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var smartPhone: SmartPhone

    @Inject
    lateinit var memoryCard: MemoryCard
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

//        DaggerSmartPhoneComponent.create().inject(this)
//        smartPhone.makeACallWithRecording()

        DaggerSmartPhoneComponent.builder().memoryCardModule(MemoryCardModule(4)).build()
            .inject(this)


//        val smartPhone = SmartPhone(
//            Battery(),
//            SIMCard(ServiceProvider()),
//            MemoryCard()
//        )
//            .makeACallWithRecording()


    }
}
