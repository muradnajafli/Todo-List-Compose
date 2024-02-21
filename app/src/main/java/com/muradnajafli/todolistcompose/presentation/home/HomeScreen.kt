package com.muradnajafli.todolistcompose.presentation.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muradnajafli.todolistcompose.data.model.TodoList
import com.muradnajafli.todolistcompose.presentation.home.components.TodoDialog
import com.muradnajafli.todolistcompose.presentation.home.components.TodoItem

@Composable
fun HomeScreen(
    todoList: List<TodoList>,
    onCreateTodo: (TodoList) -> Unit,
    onUpdateTodo: (TodoList) -> Unit,
    onDeleteTodo: (TodoList) -> Unit
) {

    val (dialogOpen, setDialogOpen) = remember {
        mutableStateOf(false)
    }

    if (dialogOpen) {
        val (title, setTitle) = remember {
            mutableStateOf("")
        }
        val (subTitle, setSubTitle) = remember {
            mutableStateOf("")
        }

        TodoDialog(
            setDialogOpen = setDialogOpen,
            title = title,
            setTitle = setTitle,
            subTitle = subTitle,
            setSubTitle = setSubTitle,
            onCreateTodo = onCreateTodo
        )
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.secondary,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { setDialogOpen(true) },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) { paddings ->
        ToDoListVisibility(
            todoList = todoList,
            paddings = paddings,
            onDeleteTodo = onDeleteTodo,
            onUpdateTodo = onUpdateTodo
        )
    }
}

@Composable
fun ToDoListVisibility(
    todoList: List<TodoList>,
    paddings: PaddingValues,
    onUpdateTodo: (TodoList) -> Unit,
    onDeleteTodo: (TodoList) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddings),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = todoList.isEmpty(),
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            Text(
                text = "No Todos Yet!",
                color = Color.White,
                fontSize = 22.sp
            )
        }
        AnimatedVisibility(
            visible = todoList.isNotEmpty(),
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        bottom = paddings.calculateBottomPadding() + 8.dp,
                        top = 8.dp,
                        end = 8.dp,
                        start = 8.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    todoList.sortedBy { it.isDone },
                    key = { it._id.toHexString() }
                ) { todo ->
                    TodoItem(
                        todo = todo,
                        onClick = {
                            val toDo = TodoList().apply {
                                this._id = todo._id
                                this.title = todo.title
                                this.subTitle = todo.subTitle
                                this.isDone = !todo.isDone
                                this.addedTime = todo.addedTime
                            }
                            onUpdateTodo(toDo)
                        },
                        onDelete = { onDeleteTodo(todo) }
                    )
                }
            }
        }
    }
}