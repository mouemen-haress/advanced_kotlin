package com.example.twowaydemo1

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUser(): List<User> {
        delay(8000)
        val users: List<User> = listOf(
            User(1, "ali"),
            User(2, "sami"),
            User(3, "mouemen"),
            User(4, "bilal")
        )
        return users
    }
}