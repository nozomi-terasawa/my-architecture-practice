package com.example.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskModelRepositoryImpl
    @Inject
    constructor(
        private val taskDao: TaskDao,
    ) : TaskModelRepository {
        //    override fun getUserById(id: Long): TaskModel? {
//        return allUserItem.value.firstOrNull { it.id == id }
//    }

        override fun getAllTasks(): Flow<List<TaskModel>> = taskDao.getAllTasks()

        override suspend fun insertTasks(task: TaskModel) = taskDao.insert(task)
    }
