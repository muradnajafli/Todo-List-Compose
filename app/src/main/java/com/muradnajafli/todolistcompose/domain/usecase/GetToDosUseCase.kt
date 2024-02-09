package com.muradnajafli.todolistcompose.domain.usecase

import com.muradnajafli.todolistcompose.data.model.ToDoEntity
import com.muradnajafli.todolistcompose.domain.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetToDosUseCaseImpl @Inject constructor(
    private val repository: ToDoRepository
) : GetToDosUseCase {

    override operator fun invoke() = repository.readAllToDos()
}

interface GetToDosUseCase {
    operator fun invoke(): Flow<List<ToDoEntity>>
}