package com.compose.noteapp.domain.note

import com.compose.noteapp.domain.time.DateTimeUtil

class SearchNoteUseCase {

    fun execute(notes: List<Note>, query: String): List<Note> =
        if (query.isBlank()) {
            notes
        } else {
            notes
                .filter {
                    it.title.trim().lowercase().contains(query.lowercase()) ||
                            it.content.trim().lowercase().contains(query.lowercase())
                }
                .sortedBy {
                    DateTimeUtil.toEpochMillis(it.created)
                }
        }
}
