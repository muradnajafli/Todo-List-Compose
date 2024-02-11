package com.muradnajafli.todolistcompose.domain.usecase

import com.muradnajafli.todolistcompose.data.model.ToDoEntity
import com.muradnajafli.todolistcompose.domain.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DeleteToDoUseCaseImpl @Inject constructor(
    private val repository: ToDoRepository
) : DeleteToDoUseCase {

    override suspend fun invoke(toDo: ToDoEntity) {
        withContext(Dispatchers.IO) {
            repository.deleteToDo(toDo)
        }
    }

}
interface DeleteToDoUseCase {
    suspend operator fun invoke(toDo: ToDoEntity)
}