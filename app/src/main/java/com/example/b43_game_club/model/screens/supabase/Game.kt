package com.example.b43_game_club.model.screens.supabase

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    var id: String = "",
    var name: String = "",
    @SerialName("id_genre")
    var idGenre: Int = 1,
    @SerialName("release_date")
    var releaseDate: String? = "",
    var developer: String = "",
    var image: String = "",
    var description: String = "",
    var rating: Float = 0F,
)
