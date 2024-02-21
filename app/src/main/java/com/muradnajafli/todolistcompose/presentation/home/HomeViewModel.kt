package com.muradnajafli.todolistcompose.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muradnajafli.todolistcompose.data.model.TodoList
import com.muradnajafli.todolistcompose.domain.usecase.todolist.AddTodoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.todolist.DeleteTodoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.todolist.GetTodosUseCase
import com.muradnajafli.todolistcompose.domain.usecase.todolist.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTodosUseCase: GetTodosUseCase,
    private val addTodoUseCase: AddTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase
) : ViewModel() {

    private val _todoList: MutableStateFlow<List<TodoList>> = MutableStateFlow(emptyList())
    val todoList = _todoList.asStateFlow()

    init {
        getTodos()
    }

    private fun getTodos() {
        viewModelScope.launch {
            getTodosUseCase().collect { result ->
                _todoList.update { result }
            }
        }
    }

    fun createTodo(todo: TodoList) {
        viewModelScope.launch {
            addTodoUseCase(todo)
        }
    }

    fun deleteTodo(todo: TodoList) {
        viewModelScope.launch {
            deleteTodoUseCase(todo)
        }
    }

    fun updateTodo(todo: TodoList) {
        viewModelScope.launch {
            updateTodoUseCase(todo)
        }
    }

}