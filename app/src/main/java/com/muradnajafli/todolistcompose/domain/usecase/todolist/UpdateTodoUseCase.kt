package com.muradnajafli.todolistcompose.domain.usecase.todolist

import com.muradnajafli.todolistcompose.data.model.TodoList
import com.muradnajafli.todolistcompose.domain.repository.TodoListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class UpdateTodoUseCaseImpl @Inject constructor(
    private val repository: TodoListRepository
) : UpdateTodoUseCase {

    override suspend fun invoke(todo: TodoList) {
        withContext(Dispatchers.IO) {
            repository.updateTodo(todo)
        }
    }
}

interface UpdateTodoUseCase {
    suspend operator fun invoke(todo: TodoList)
}