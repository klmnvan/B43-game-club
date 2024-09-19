package com.example.b43_game_club.model.screens.supabase

import kotlinx.serialization.Serializable

@Serializable
data class GetGamesResponse(
    var games: MutableList<Game> = mutableListOf(),
    var genres: MutableList<Genre> = mutableListOf(),
    var error: String = ""
)
