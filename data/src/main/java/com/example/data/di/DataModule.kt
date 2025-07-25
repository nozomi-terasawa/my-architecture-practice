package com.example.data.di

import com.example.data.UserModelRepository
import com.example.data.UserModelRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    // Todo 間違えてる？
//    @Binds
//    abstract fun bindUserModelRepository(
//        repository: UserModelRepositoryImpl
//    ): UserModelRepositoryImpl

    @Binds
    @Singleton
    abstract fun bindUserModelRepository(impl: UserModelRepositoryImpl): UserModelRepository
}
