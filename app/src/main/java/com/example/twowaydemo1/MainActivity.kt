package com.example.twowaydemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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


        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Main).launch {
                tvCount.text = UserDataManagerOne().getTotalUserCount().toString()
            }
        }
    }

}
