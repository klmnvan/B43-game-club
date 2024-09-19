package com.example.b43_game_club.model.responses

import com.example.b43_game_club.model.supabase.Game
import com.example.b43_game_club.model.supabase.Genre
import kotlinx.serialization.Serializable

@Serializable
data class GetGamesResponse(
    var games: MutableList<Game> = mutableListOf(),
    var genres: MutableList<Genre> = mutableListOf(),
    var error: String = ""
)
