package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.TaskDao
import com.example.data.TaskDatabase
import com.example.data.TaskModelRepository
import com.example.data.TaskModelRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindUserModelRepository(repositoryImpl: TaskModelRepositoryImpl): TaskModelRepository

    companion object {
        @Provides
        @Singleton
        fun provideDatabase(
            @ApplicationContext appContext: Context,
        ): TaskDatabase =
            Room
                .databaseBuilder(appContext, TaskDatabase::class.java, "task_database")
                .fallbackToDestructiveMigration() // 開発中は推奨
                .build()

        @Provides
        @Singleton
        fun provideTaskDao(database: TaskDatabase): TaskDao = database.taskDao()
    }
}
