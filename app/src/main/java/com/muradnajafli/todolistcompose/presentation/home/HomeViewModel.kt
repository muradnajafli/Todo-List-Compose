package com.muradnajafli.todolistcompose.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muradnajafli.todolistcompose.data.model.TodoEntity
import com.muradnajafli.todolistcompose.domain.usecase.AddTodoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.DeleteTodoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.GetTodosUseCase
import com.muradnajafli.todolistcompose.domain.usecase.UpdateTodoUseCase
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
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase
) : ViewModel() {

    private val _todoList: MutableStateFlow<List<TodoEntity>> = MutableStateFlow(emptyList())
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

    fun createTodo(todo: TodoEntity) {
        viewModelScope.launch {
            addTodoUseCase(todo)
        }
    }

    fun updateTodo(todo: TodoEntity) {
        viewModelScope.launch {
            updateTodoUseCase(todo)
        }
    }

    fun deleteTodo(todo: TodoEntity) {
        viewModelScope.launch {
            deleteTodoUseCase(todo)
        }
    }

}