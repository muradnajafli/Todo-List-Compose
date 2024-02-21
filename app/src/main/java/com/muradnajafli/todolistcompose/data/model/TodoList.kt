package com.muradnajafli.todolistcompose.data.model

import android.icu.text.SimpleDateFormat
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId
import java.util.Date
import java.util.Locale

class TodoList: RealmObject {
    @PrimaryKey var _id: ObjectId = ObjectId()
    var title: String = ""
    var subTitle: String = ""
    var isDone: Boolean = false
    var addedTime: Long = System.currentTimeMillis()
}

val TodoList.addDate: String
    get() = SimpleDateFormat("yyyy/MM/dd hh:mm", Locale.ENGLISH)
        .format(Date(addedTime))