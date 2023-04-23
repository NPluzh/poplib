package com.example.poplib.di.module

import androidx.room.Room
import com.example.poplib.ui.App
import com.example.poplib.mvp.model.entity.room.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun database(app: App): Database = Room.databaseBuilder(app, Database::class.java, Database.DB_NAME)
        .build()

}
