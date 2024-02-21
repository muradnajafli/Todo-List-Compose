package com.muradnajafli.todolistcompose.domain.usecase.todolist

import com.muradnajafli.todolistcompose.data.model.TodoList
import com.muradnajafli.todolistcompose.domain.repository.TodoListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddTodoUseCaseImpl @Inject constructor(
    private val repository: TodoListRepository
) : AddTodoUseCase {

    override suspend fun invoke(todo: TodoList) {
        withContext(Dispatchers.IO) {
            repository.addTodo(todo)
        }
    }
}

interface AddTodoUseCase {
    suspend operator fun invoke(todo: TodoList)
}