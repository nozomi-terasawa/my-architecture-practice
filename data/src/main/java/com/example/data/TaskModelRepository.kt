package com.example.data

import kotlinx.coroutines.flow.Flow

interface TaskModelRepository {
    // TODO 後に修正
    // fun getUserById(id: Long): TaskModel?

    fun getAllTasks(): Flow<List<TaskModel>>

    suspend fun insertTasks(task: TaskModel)
}
