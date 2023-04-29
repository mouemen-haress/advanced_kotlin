package com.example.twowaydemo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    val total = MutableLiveData<Int>()
    val inputText = MutableLiveData<String>()


    init {
        total.value = 0
    }

    fun add() {
        var inputText = inputText.value!!.toInt()
        total.value = total.value?.plus(inputText)
    }

}