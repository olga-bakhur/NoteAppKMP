package com.compose.noteapp.data.note

import com.compose.noteapp.domain.note.Note
import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun NoteEntity.toNote(): Note = Note(
    id = id,
    title = title,
    content = content,
    colorHex = colorHex,
    created = Instant
        .fromEpochMilliseconds(created)
        .toLocalDateTime(TimeZone.currentSystemDefault())
)