package com.example.data.di

import com.example.data.UserModelRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindUserModelRepository(
        repository: UserModelRepositoryImpl
    ): UserModelRepositoryImpl
}
