package com.muradnajafli.todolistcompose.data.repository

import com.muradnajafli.todolistcompose.data.database.ToDoDao
import com.muradnajafli.todolistcompose.data.model.ToDoEntity
import com.muradnajafli.todolistcompose.domain.repository.ToDoRepository
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(
    private val toDoDao: ToDoDao
) : ToDoRepository {

    override fun readAllToDos() = toDoDao.readAllToDos()
    override suspend fun addToDo(toDo: ToDoEntity) = toDoDao.addToDo(toDo)
    override suspend fun updateToDo(toDo: ToDoEntity) = toDoDao.updateToDo(toDo)
    override suspend fun deleteToDo(toDo: ToDoEntity) = toDoDao.deleteToDo(toDo)

}