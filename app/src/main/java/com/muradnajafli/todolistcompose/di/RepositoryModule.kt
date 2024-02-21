package com.muradnajafli.todolistcompose.di

import com.muradnajafli.todolistcompose.data.repository.TodoListRepositoryImpl
import com.muradnajafli.todolistcompose.domain.repository.TodoListRepository
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
    fun bindToDoListRepository(
        toDoRepositoryImpl: TodoListRepositoryImpl
    ): TodoListRepository

}