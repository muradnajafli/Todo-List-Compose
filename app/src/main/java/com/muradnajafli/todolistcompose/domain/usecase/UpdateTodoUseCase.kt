package com.muradnajafli.todolistcompose.domain.usecase

import com.muradnajafli.todolistcompose.data.model.TodoEntity
import com.muradnajafli.todolistcompose.domain.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class UpdateTodoUseCaseImpl @Inject constructor(
    private val repository: TodoRepository
) : UpdateTodoUseCase {

    override suspend fun invoke(todo: TodoEntity) {
        withContext(Dispatchers.IO) {
            repository.updateTodo(todo)
        }
    }
}

interface UpdateTodoUseCase {
    suspend operator fun invoke(todo: TodoEntity)
}