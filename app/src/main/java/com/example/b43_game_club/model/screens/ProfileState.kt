package com.example.b43_game_club.model.screens

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileState(
    var id: String = "",
    var name: String = "",
    var surname: String = "",
    var patronymic: String = "",
    @SerialName("id_role")
    var role: String = "",
    var email: String = "",
    var amountRansom: Float = 0f,
    var hours: Int = 0,
)
