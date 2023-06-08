package com.example.twowaydemo1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {
    private var userRepository = UserRepository()

    var users = liveData(IO) {
        val result = userRepository.getUser()
        emit(result)
    }
//    var users: MutableLiveData<List<User>?> = MutableLiveData()

//    fun getUsers() {
//        viewModelScope.launch {
//            var result: List<User>? = null
//            withContext(IO) {
//                result = userRepository.getUser()
//            }
//            users.value = result
//        }
//    }
}