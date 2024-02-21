package com.muradnajafli.todolistcompose.domain.usecase.todolist

import com.muradnajafli.todolistcompose.data.model.TodoList
import com.muradnajafli.todolistcompose.domain.repository.TodoListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodosUseCaseImpl @Inject constructor(
    private val repository: TodoListRepository
) : GetTodosUseCase {

    override operator fun invoke() = repository.readAllTodos()
}

interface GetTodosUseCase {
    operator fun invoke(): Flow<List<TodoList>>
}