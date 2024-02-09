package com.muradnajafli.todolistcompose.ui.home

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muradnajafli.todolistcompose.ui.ToDoDialog
import com.muradnajafli.todolistcompose.ui.model.ToDoItem

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val toDos by viewModel.toDoList.collectAsState()
    Log.i("TO_DO_LIST", "HomeScreen: $toDos")

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

        ToDoDialog(
            setDialogOpen = setDialogOpen,
            title = title,
            setTitle = setTitle,
            subTitle = subTitle,
            setSubTitle = setSubTitle,
            viewModel = viewModel
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddings),
            contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(
                visible = toDos.isEmpty(),
                enter = scaleIn() + fadeIn(),
                exit = scaleOut() + fadeOut()
            ) {
                Log.i("IS_EMPTY", "HomeScreen: ${toDos.isEmpty()}")
                Text(
                    text = "No ToDos Yet!",
                    color = Color.White,
                    fontSize = 22.sp
                )
            }
            AnimatedVisibility(
                visible = toDos.isNotEmpty(),
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
                        toDos.sortedBy { it.isDone },
                        key = { it.id }
                    ) {todo ->
                        ToDoItem(
                            toDo = todo,
                            onClick = { viewModel.updateToDo(
                                todo.copy(
                                    isDone = !todo.isDone
                                )
                            ) },
                            onDelete = { viewModel.deleteToDo(todo) }
                        )
                    }
                }
            }
        }
    }
}