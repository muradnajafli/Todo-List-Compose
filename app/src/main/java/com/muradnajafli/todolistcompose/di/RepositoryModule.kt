package com.muradnajafli.todolistcompose.di

import com.muradnajafli.todolistcompose.data.repository.TodoRepositoryImpl
import com.muradnajafli.todolistcompose.domain.repository.TodoRepository
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
        toDoRepositoryImpl: TodoRepositoryImpl
    ): TodoRepository

}