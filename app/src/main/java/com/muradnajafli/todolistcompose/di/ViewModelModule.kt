package com.muradnajafli.todolistcompose.di

import com.muradnajafli.todolistcompose.domain.repository.ToDoRepository
import com.muradnajafli.todolistcompose.domain.usecase.AddToDoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.AddToDoUseCaseImpl
import com.muradnajafli.todolistcompose.domain.usecase.DeleteToDoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.DeleteToDoUseCaseImpl
import com.muradnajafli.todolistcompose.domain.usecase.GetToDosUseCase
import com.muradnajafli.todolistcompose.domain.usecase.GetToDosUseCaseImpl
import com.muradnajafli.todolistcompose.domain.usecase.UpdateToDoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.UpdateToDoUseCaseImpl
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
        repository: ToDoRepository
    ): GetToDosUseCase {
        return GetToDosUseCaseImpl(repository)
    }

    @Provides
    @ViewModelScoped
    fun addToDo(
        repository: ToDoRepository
    ): AddToDoUseCase {
        return AddToDoUseCaseImpl(repository)
    }

    @Provides
    @ViewModelScoped
    fun updateToDo(
        repository: ToDoRepository
    ): UpdateToDoUseCase {
        return UpdateToDoUseCaseImpl(repository)
    }

    @Provides
    @ViewModelScoped
    fun deleteToDo(
        repository: ToDoRepository
    ): DeleteToDoUseCase {
        return DeleteToDoUseCaseImpl(repository)
    }

}