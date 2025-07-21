package com.example.data

interface UserModelRepository {
    fun getUserById(id: Long): UserModel?

    fun getAllUsers(): List<UserModel>
}