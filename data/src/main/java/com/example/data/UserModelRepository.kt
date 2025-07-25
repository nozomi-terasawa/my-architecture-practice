package com.example.data

import kotlinx.coroutines.flow.Flow

interface UserModelRepository {
    fun getUserById(id: Long): Flow<UserModel>

    fun getAllUsers(): Flow<List<UserModel>>
}
