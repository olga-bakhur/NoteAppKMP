package com.compose.noteapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform