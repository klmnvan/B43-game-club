package com.example.b43_game_club.model.responses

import com.example.b43_game_club.model.supabase.GamePackage
import kotlinx.serialization.Serializable

@Serializable
data class GetGamePackagesResponse(
    var gamePackages: MutableList<GamePackage> = mutableListOf(),
    var error: String = ""
)
