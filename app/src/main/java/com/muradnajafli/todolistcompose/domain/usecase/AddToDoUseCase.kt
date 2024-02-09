package com.muradnajafli.todolistcompose.domain.usecase

import com.muradnajafli.todolistcompose.data.model.ToDoEntity
import com.muradnajafli.todolistcompose.domain.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddToDoUseCaseImpl @Inject constructor(
    private val repository: ToDoRepository
) : AddToDoUseCase {

    override suspend fun invoke(toDo: ToDoEntity) {
        withContext(Dispatchers.IO) {
            repository.addToDo(toDo)
        }
    }
}

interface AddToDoUseCase {
    suspend operator fun invoke(toDo: ToDoEntity)
}