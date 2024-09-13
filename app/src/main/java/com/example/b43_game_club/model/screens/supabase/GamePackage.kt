package com.example.b43_game_club.model.screens.supabase

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GamePackage(
    var id: Int = 1,
    var time: Int = 0,
    var price: Int = 0,
    @SerialName("id_type")
    var idType: Int = 1,
)
