package com.example.twowaydemo1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twowaydemo1.data.Conversion
import com.example.twowaydemo1.data.ConversionReults
import com.example.twowaydemo1.data.ConverterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConvertViewModel(private val repository: ConverterRepository) : ViewModel() {
    fun getConversion() = listOf(
        Conversion(1, "Pounds to Kilograms", "lbs", "kg", 0.453592),
        Conversion(2, "Kilograms to Pounds", "kg", "lbs", 2.20462),
        Conversion(3, "Yards to Meters", "yd", "m", 0.9144),
        Conversion(4, "Meters to Yards", "m", "yd", 1.09361),
        Conversion(5, "Miles to Kilometers", "mi", "km", 1.60934),
        Conversion(6, "Kilometers to Miles", "km", "mi", 0.621371)
    )

    fun addResult(messageOne: String, messageTwo: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertResult(ConversionReults(0, messageOne, messageTwo))
        }
    }
}