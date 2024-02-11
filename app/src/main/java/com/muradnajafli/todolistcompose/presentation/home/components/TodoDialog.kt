package com.muradnajafli.todolistcompose.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.muradnajafli.todolistcompose.data.model.TodoEntity
import com.muradnajafli.todolistcompose.presentation.theme.ubuntu

@Composable
fun TodoDialog(
    setDialogOpen: (Boolean) -> Unit,
    title: String,
    setTitle: (String) -> Unit,
    subTitle: String,
    setSubTitle: (String) -> Unit,
    onCreateTodo: (TodoEntity) -> Unit,
) {
    Dialog(
        onDismissRequest = { setDialogOpen(false) }
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.primary)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ToDoTextField(
                text = "Title",
                value = title,
                setValue = setTitle
            )
            Spacer(modifier = Modifier.height(4.dp))
            ToDoTextField(
                text = "Sub Title",
                value = subTitle,
                setValue = setSubTitle
            )
            Spacer(modifier = Modifier.height(18.dp))
            Button(
                onClick = {
                    if (title.isNotEmpty() && subTitle.isNotEmpty()) {
                        onCreateTodo(
                            TodoEntity().apply {
                                this.title = title
                                this.subTitle = subTitle
                            }
                        )
                        setDialogOpen(false)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Submit",
                    color = Color.White,
                    fontFamily = ubuntu
                )
            }
        }
    }
}

@Composable
fun ToDoTextField(
    text: String,
    value: String,
    setValue: (String) -> Unit
) {
    OutlinedTextField(
        label = { Text(text = text) },
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Color.White,
            focusedTextColor = Color.White
        ),
        value = value,
        onValueChange = { setValue(it) },
        modifier = Modifier
            .fillMaxWidth()
    )
}