package com.example.data

import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class UserModelRepositoryImpl @Inject constructor() : UserModelRepository{

    // ダミーデータ
    private val allUserItem: MutableStateFlow<List<UserModel>> = MutableStateFlow(
        listOf(
            UserModel(
                id = 1,
                name = "John Doe",
                email = "example1@gmail.com",
                isActive = true
            ),
            UserModel(
                id = 2,
                name = "Jane Smith",
                email = "example2@gmail.com",
                isActive = false
            ),
            UserModel(
                id = 3,
                name = "Alice Johnson",
                email = "example3@gmail.com",
                isActive = true
            ),
            UserModel(
                id = 4,
                name = "Bob Brown",
                email = "example5@gmail.com",
                isActive = false
            )
        )
    )

    override fun getUserById(id: Long): UserModel? {
        return allUserItem.value.firstOrNull { it.id == id }
    }

    override fun getAllUsers(): List<UserModel> {
        return allUserItem.value
    }
}