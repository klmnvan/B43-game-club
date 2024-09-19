package com.example.b43_game_club.model.screens.supabase

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PurchasedPackages(
    var id: Int = 0,
    var cost: Float = 0F,
    var hours: Int = 0,
    @SerialName("id_user")
    var idUser: String = ""
)
