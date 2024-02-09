package com.muradnajafli.todolistcompose.domain.repository

import com.muradnajafli.todolistcompose.data.model.ToDoEntity
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    fun readAllToDos(): Flow<List<ToDoEntity>>
    suspend fun addToDo(toDo: ToDoEntity)
    suspend fun updateToDo(toDo: ToDoEntity)
    suspend fun deleteToDo(toDo: ToDoEntity)
}