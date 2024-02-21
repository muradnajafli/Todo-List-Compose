package com.muradnajafli.todolistcompose.domain.repository

import com.muradnajafli.todolistcompose.data.model.TodoList
import kotlinx.coroutines.flow.Flow

interface TodoListRepository {
    fun readAllTodos(): Flow<List<TodoList>>
    suspend fun addTodo(todo: TodoList)
    suspend fun deleteTodo(todo: TodoList)
    suspend fun updateTodo(todo: TodoList)
}