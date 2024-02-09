package com.muradnajafli.todolistcompose.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.muradnajafli.todolistcompose.data.model.ToDoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query(value = "SELECT * FROM toDo_table")
    fun readAllToDos(): Flow<List<ToDoEntity>>

    @Insert
    suspend fun addToDo(toDo: ToDoEntity)

    @Delete
    suspend fun deleteToDo(toDo: ToDoEntity)

    @Update
    suspend fun updateToDo(toDo: ToDoEntity)

}