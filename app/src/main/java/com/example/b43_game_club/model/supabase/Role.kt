package com.example.b43_game_club.model.supabase

import kotlinx.serialization.Serializable

@Serializable
data class Role(
    var id: Int = 1,
    var name: String = "",
)
