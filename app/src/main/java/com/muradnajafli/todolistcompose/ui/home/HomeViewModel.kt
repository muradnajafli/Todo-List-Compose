package com.muradnajafli.todolistcompose.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muradnajafli.todolistcompose.data.model.ToDoEntity
import com.muradnajafli.todolistcompose.domain.usecase.AddToDoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.DeleteToDoUseCase
import com.muradnajafli.todolistcompose.domain.usecase.GetToDosUseCase
import com.muradnajafli.todolistcompose.domain.usecase.UpdateToDoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getToDosUseCase: GetToDosUseCase,
    private val addToDoUseCase: AddToDoUseCase,
    private val updateToDoUseCase: UpdateToDoUseCase,
    private val deleteToDoUseCase: DeleteToDoUseCase
) : ViewModel() {

    private val _toDoList: MutableStateFlow<List<ToDoEntity>> = MutableStateFlow(emptyList())
    val toDoList = _toDoList.asStateFlow()

    init {
        viewModelScope.launch {
            getToDosUseCase().collect {
                Log.d("ViewModel", "Fetched todos: $it")
                _toDoList.update { it }
            }
        }
    }

    fun createToDo(toDoEntity: ToDoEntity) {
        viewModelScope.launch {
            addToDoUseCase(toDoEntity)
        }
    }

    fun updateToDo(toDoEntity: ToDoEntity) {
        viewModelScope.launch {
            updateToDoUseCase(toDoEntity)
        }

    }

    fun deleteToDo(toDoEntity: ToDoEntity) {
        viewModelScope.launch {
            deleteToDoUseCase(toDoEntity)
        }
    }
}