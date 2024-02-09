package com.muradnajafli.todolistcompose.di

import com.muradnajafli.todolistcompose.data.repository.ToDoRepositoryImpl
import com.muradnajafli.todolistcompose.domain.repository.ToDoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindToDoRepository(
        toDoRepositoryImpl: ToDoRepositoryImpl
    ): ToDoRepository

}