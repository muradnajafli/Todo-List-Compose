package com.muradnajafli.todolistcompose.di

import com.muradnajafli.todolistcompose.data.model.TodoList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(): Realm {
        return Realm.open(
            configuration = RealmConfiguration.create(
                schema = setOf(
                    TodoList::class
                )
            )
        )
    }

}