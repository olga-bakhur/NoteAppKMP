package com.compose.noteapp.android.di

import android.app.Application
import com.compose.noteapp.data.local.DatabaseDriverFactory
import com.compose.noteapp.data.note.SQLDelightDataSource
import com.compose.noteapp.database.NoteDatabase
import com.compose.noteapp.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource {
        return SQLDelightDataSource(NoteDatabase(driver))
    }
}