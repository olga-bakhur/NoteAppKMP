package com.compose.noteapp.data.note

import com.compose.noteapp.database.NoteDatabase
import com.compose.noteapp.domain.note.Note
import com.compose.noteapp.domain.note.NoteDataSource
import com.compose.noteapp.domain.time.DateTimeUtil

class SQLDelightDataSource(
    dp: NoteDatabase
): NoteDataSource {

    private val queries = dp.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            created = DateTimeUtil.toEpochMillis(note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries
            .getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries
            .getAllNotes()
            .executeAsList()
            .map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNoteById(id)
    }
}