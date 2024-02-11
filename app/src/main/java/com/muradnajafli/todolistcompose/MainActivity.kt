package com.muradnajafli.todolistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.muradnajafli.todolistcompose.presentation.home.HomeScreen
import com.muradnajafli.todolistcompose.presentation.home.HomeViewModel
import com.muradnajafli.todolistcompose.presentation.theme.TodoListComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: HomeViewModel = hiltViewModel<HomeViewModel>()
                    val todoList by viewModel.todoList.collectAsStateWithLifecycle()
                    HomeScreen(
                        todoList = todoList,
                        onCreateTodo = viewModel::createTodo,
                        onUpdateTodo = viewModel::updateTodo,
                        onDeleteTodo = viewModel::deleteTodo
                    )
                }
            }
        }
    }
}