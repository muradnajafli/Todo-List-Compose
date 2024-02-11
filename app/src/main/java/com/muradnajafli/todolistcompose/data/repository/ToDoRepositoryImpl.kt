package com.muradnajafli.todolistcompose.data.repository

import com.muradnajafli.todolistcompose.data.model.ToDoEntity
import com.muradnajafli.todolistcompose.domain.repository.ToDoRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(
    private val realm: Realm
) : ToDoRepository {

    override fun readAllToDos(): Flow<List<ToDoEntity>> {
        return realm.query<ToDoEntity>().asFlow().map { it.list }
    }

    override suspend fun addToDo(toDo: ToDoEntity) {
        realm.write { copyToRealm(toDo) }
    }

    override suspend fun updateToDo(toDo: ToDoEntity) {
        realm.write {
            val queriedToDo = query<ToDoEntity>(query = "_id == $0", toDo._id).first().find()
            queriedToDo?.let {
                it.isDone = toDo.isDone
            }
        }
    }

    override suspend fun deleteToDo(toDo: ToDoEntity) {
        realm.write {
            findLatest(toDo)?.let { delete(it) }
        }
    }

}