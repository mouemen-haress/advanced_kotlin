package com.example.twowaydemo1.Model

import kotlinx.coroutines.delay

class UserRpository {

    suspend fun getUsers(): List<User> {
        delay(8000)
        val users: List<User> = listOf(
            User(1, "ali"),
            User(3, "sami"),
            User(4, "abli"),
            User(5, "ugly"),
        )
        return users
    }
}