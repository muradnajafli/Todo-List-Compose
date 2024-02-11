package com.muradnajafli.todolistcompose.domain.usecase

import com.muradnajafli.todolistcompose.data.model.TodoEntity
import com.muradnajafli.todolistcompose.domain.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DeleteTodoUseCaseImpl @Inject constructor(
    private val repository: TodoRepository
) : DeleteTodoUseCase {

    override suspend fun invoke(todo: TodoEntity) {
        withContext(Dispatchers.IO) {
            repository.deleteTodo(todo)
        }
    }

}
interface DeleteTodoUseCase {
    suspend operator fun invoke(todo: TodoEntity)
}