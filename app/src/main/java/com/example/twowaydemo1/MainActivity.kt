package com.example.twowaydemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    private var count = 0

    private lateinit var btnDownloadUserData: Button
    private lateinit var btnCount: Button
    private lateinit var tvCount: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        btnDownloadUserData = findViewById(R.id.btnDownloadUserData)
        btnCount = findViewById(R.id.btnCount)
        tvCount = findViewById(R.id.tvCount)

        // async task inside IO THREAD
//        CoroutineScope(IO).launch {
//
//            val stockOne = async { getStockOne() }
//            val stockTwo = async { getStockTwo() }
//
//            val result = stockOne.await() + stockTwo.await()
//            Log.i("MyTag", "result =  " + result)
//
//        }


        // async task inside MAIN THREAD
        CoroutineScope(Main).launch {

            val stockOne = async(IO) { getStockOne() }
            val stockTwo = async(IO) { getStockTwo() }

            val result = stockOne.await() + stockTwo.await()
            Toast.makeText(applicationContext, "rsult is : $result", Toast.LENGTH_SHORT).show()
        }

    }

    private suspend fun getStockOne(): Int {
        delay(10000)
        Log.i("MyTag", "stock 1 returned")
        return 55000
    }

    private suspend fun getStockTwo(): Int {
        delay(8000)
        Log.i("MyTag", "stock 2 returned")
        return 35000
    }
}
