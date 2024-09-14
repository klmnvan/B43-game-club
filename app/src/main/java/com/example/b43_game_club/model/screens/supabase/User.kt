package com.example.b43_game_club.model.screens.supabase

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id: String = "",
    var name: String = "",
    var surname: String = "",
    var patronymic: String = "",
    @SerialName("id_role")
    var idRole: Int = 1,
    var image: String = ""
)
