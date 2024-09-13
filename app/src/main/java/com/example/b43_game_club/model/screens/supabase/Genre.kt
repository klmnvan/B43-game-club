package com.example.b43_game_club.model.screens.supabase

import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    var id: Int = 1,
    var name: String = "",
)
