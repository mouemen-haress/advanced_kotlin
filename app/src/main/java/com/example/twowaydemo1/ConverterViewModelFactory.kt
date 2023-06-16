package com.example.twowaydemo1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.twowaydemo1.data.ConverterRepository
import javax.inject.Inject

class ConverterViewModelFactory @Inject constructor(private val repository: ConverterRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = ConvertViewModel(repository) as T


}