package com.muradnajafli.todolistcompose.domain.usecase.todolist

import com.muradnajafli.todolistcompose.data.model.TodoList
import com.muradnajafli.todolistcompose.domain.repository.TodoListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DeleteTodoUseCaseImpl @Inject constructor(
    private val repository: TodoListRepository
) : DeleteTodoUseCase {

    override suspend fun invoke(todo: TodoList) {
        withContext(Dispatchers.IO) {
            repository.deleteTodo(todo)
        }
    }

}
interface DeleteTodoUseCase {
    suspend operator fun invoke(todo: TodoList)
}