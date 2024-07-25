package com.compose.noteapp.domain.note

import com.compose.noteapp.presentation.BabyBlueHex
import com.compose.noteapp.presentation.LightGreenHex
import com.compose.noteapp.presentation.RedOrangeHex
import com.compose.noteapp.presentation.RedPinkHex
import com.compose.noteapp.presentation.VioletHex
import kotlinx.datetime.LocalDateTime


data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime,
) {

    companion object {
        private val colors = listOf(
            RedOrangeHex,
            RedPinkHex,
            BabyBlueHex,
            VioletHex,
            LightGreenHex
        )

        fun generateRandomColor() = colors.random()
    }
}
