package com.muradnajafli.todolistcompose.domain.repository

import com.muradnajafli.todolistcompose.data.model.TodoEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun readAllTodos(): Flow<List<TodoEntity>>
    suspend fun addTodo(todo: TodoEntity)
    suspend fun updateTodo(todo: TodoEntity)
    suspend fun deleteTodo(todo: TodoEntity)
}