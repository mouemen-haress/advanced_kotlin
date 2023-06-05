package com.example.twowaydemo1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twowaydemo1.Model.User
import com.example.twowaydemo1.Model.UserRpository
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class MainActivityViewModel : ViewModel() {
    private val userRepository = UserRpository()
    var users: MutableLiveData<List<User>?> = MutableLiveData()


    fun getUserData() {
        viewModelScope.launch {
            var result: List<User>? = null
            withContext(IO) {
                result = userRepository.getUsers()
            }

            users.value = result
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}