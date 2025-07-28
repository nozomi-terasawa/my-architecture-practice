package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName = "tasks")
data class TaskModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val createAt: Instant = Instant.now(),
    val dueDate: Instant,
    val priority: Priority,
    val isCompleted: Boolean = false,
)

enum class Priority {
    LOW,
    MIDDLE,
    HEIGHT,
}
