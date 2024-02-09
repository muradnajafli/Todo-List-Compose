package com.muradnajafli.todolistcompose.data.model

import android.icu.text.SimpleDateFormat
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.Locale

@Entity(tableName = "toDo_table")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val subTitle: String,
    val isDone: Boolean = false,
    val addedTime: Long = System.currentTimeMillis()
)


val ToDoEntity.addDate:String
    get() = SimpleDateFormat("yyyy/MM/dd hh:mm", Locale.ENGLISH)
        .format(Date(addedTime))