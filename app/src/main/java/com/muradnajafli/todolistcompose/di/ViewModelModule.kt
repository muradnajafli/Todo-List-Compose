package com.muradnajafli.todolistcompose.di

import com.muradnajafli.todolistcompose.domain.repository.TodoRepository
import com.muradnajafli.todolistcompose.domain.usecase.AddTodoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.AddTodoUseCaseImpl
import com.muradnajafli.todolistcompose.domain.usecase.DeleteTodoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.DeleteTodoUseCaseImpl
import com.muradnajafli.todolistcompose.domain.usecase.GetTodosUseCase
import com.muradnajafli.todolistcompose.domain.usecase.GetTodosUseCaseImpl
import com.muradnajafli.todolistcompose.domain.usecase.UpdateTodoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.UpdateTodoUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun getToDos(
        repository: TodoRepository
    ): GetTodosUseCase {
        return GetTodosUseCaseImpl(repository)
    }

    @Provides
    @ViewModelScoped
    fun addToDo(
        repository: TodoRepository
    ): AddTodoUseCase {
        return AddTodoUseCaseImpl(repository)
    }

    @Provides
    @ViewModelScoped
    fun updateToDo(
        repository: TodoRepository
    ): UpdateTodoUseCase {
        return UpdateTodoUseCaseImpl(repository)
    }

    @Provides
    @ViewModelScoped
    fun deleteToDo(
        repository: TodoRepository
    ): DeleteTodoUseCase {
        return DeleteTodoUseCaseImpl(repository)
    }

}