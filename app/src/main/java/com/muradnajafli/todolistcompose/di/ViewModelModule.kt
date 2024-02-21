package com.muradnajafli.todolistcompose.di

import com.muradnajafli.todolistcompose.domain.repository.TodoListRepository
import com.muradnajafli.todolistcompose.domain.usecase.todolist.AddTodoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.todolist.AddTodoUseCaseImpl
import com.muradnajafli.todolistcompose.domain.usecase.todolist.DeleteTodoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.todolist.DeleteTodoUseCaseImpl
import com.muradnajafli.todolistcompose.domain.usecase.todolist.GetTodosUseCase
import com.muradnajafli.todolistcompose.domain.usecase.todolist.GetTodosUseCaseImpl
import com.muradnajafli.todolistcompose.domain.usecase.todolist.UpdateTodoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.todolist.UpdateTodoUseCaseImpl
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
    fun provideGetTodos(
        repository: TodoListRepository
    ): GetTodosUseCase {
        return GetTodosUseCaseImpl(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideAddTodo(
        repository: TodoListRepository
    ): AddTodoUseCase {
        return AddTodoUseCaseImpl(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideDeleteTodo(
        repository: TodoListRepository
    ): DeleteTodoUseCase {
        return DeleteTodoUseCaseImpl(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideUpdateTodo(
        repository: TodoListRepository
    ): UpdateTodoUseCase {
        return UpdateTodoUseCaseImpl(repository)
    }

}