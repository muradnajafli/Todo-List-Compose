package com.muradnajafli.todolistcompose.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.muradnajafli.todolistcompose.data.database.ToDoDao
import com.muradnajafli.todolistcompose.data.database.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): ToDoDatabase {
        return Room.databaseBuilder(
            app,
            ToDoDatabase::class.java,
            "toDo_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideFavMovieDao(db: ToDoDatabase): ToDoDao {
        return db.toDoDao()
    }

}