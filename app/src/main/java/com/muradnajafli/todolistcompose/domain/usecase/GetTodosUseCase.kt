package com.muradnajafli.todolistcompose.domain.usecase

import com.muradnajafli.todolistcompose.data.model.TodoEntity
import com.muradnajafli.todolistcompose.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodosUseCaseImpl @Inject constructor(
    private val repository: TodoRepository
) : GetTodosUseCase {

    override operator fun invoke() = repository.readAllTodos()
}

interface GetTodosUseCase {
    operator fun invoke(): Flow<List<TodoEntity>>
}