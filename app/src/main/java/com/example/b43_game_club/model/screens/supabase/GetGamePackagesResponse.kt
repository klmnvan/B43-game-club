package com.example.b43_game_club.model.screens.supabase

import kotlinx.serialization.Serializable

@Serializable
data class GetGamePackagesResponse(
    var gamePackages: MutableList<GamePackage> = mutableListOf(),
    var error: String = ""
)
