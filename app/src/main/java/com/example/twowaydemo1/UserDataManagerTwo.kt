package com.example.twowaydemo1

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class UserDataManagerTwo {

    suspend fun getTotalUserCount(): Int {
        var count = 0
        lateinit var deferred:Deferred<Int>

        coroutineScope {
            launch(IO) {
                delay(1000)
                count = 50
            }
            deferred = async(IO) {
                delay(3000)
                return@async 70
            }

        }
        return count + deferred.await()

    }
}