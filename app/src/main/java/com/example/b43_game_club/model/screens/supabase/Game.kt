package com.example.b43_game_club.model.screens.supabase

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    var id: Int = 0,
    var name: String = "",
    var developer: String = "",
    var rating: Float = 0F,
    @SerialName("release_year")
    var releaseYear: String? = "",
    var image: String = "",
    var description: String = "",
    @SerialName("id_genre")
    var idGenre: Int = 1,
)
