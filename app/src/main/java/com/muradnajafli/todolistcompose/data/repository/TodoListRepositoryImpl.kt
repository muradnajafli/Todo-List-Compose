package com.muradnajafli.todolistcompose.data.repository

import com.muradnajafli.todolistcompose.data.model.TodoList
import com.muradnajafli.todolistcompose.domain.repository.TodoListRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoListRepositoryImpl @Inject constructor(
    private val realm: Realm
) : TodoListRepository {

    override fun readAllTodos(): Flow<List<TodoList>> {
        return realm.query<TodoList>().asFlow().map { it.list }
    }

    override suspend fun addTodo(todo: TodoList) {
        realm.write { copyToRealm(todo) }
    }

    override suspend fun updateTodo(todo: TodoList) {
        realm.write {
            val queriedTodo = query<TodoList>(query = "_id == $0", todo._id).first().find()
            queriedTodo?.let {
                it.isDone = todo.isDone
            }
        }
    }

    override suspend fun deleteTodo(todo: TodoList) {
        realm.write {
            findLatest(todo)?.let { delete(it) }
        }
    }

}