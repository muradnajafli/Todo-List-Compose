package com.muradnajafli.todolistcompose.data.repository

import com.muradnajafli.todolistcompose.data.model.TodoEntity
import com.muradnajafli.todolistcompose.domain.repository.TodoRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val realm: Realm
) : TodoRepository {

    override fun readAllTodos(): Flow<List<TodoEntity>> {
        return realm.query<TodoEntity>().asFlow().map { it.list }
    }

    override suspend fun addTodo(todo: TodoEntity) {
        realm.write { copyToRealm(todo) }
    }

    override suspend fun updateTodo(todo: TodoEntity) {
        realm.write {
            val queriedTodo = query<TodoEntity>(query = "_id == $0", todo._id).first().find()
            queriedTodo?.let {
                it.isDone = todo.isDone
            }
        }
    }

    override suspend fun deleteTodo(todo: TodoEntity) {
        realm.write {
            findLatest(todo)?.let { delete(it) }
        }
    }

}