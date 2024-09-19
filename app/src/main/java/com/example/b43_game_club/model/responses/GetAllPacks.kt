package com.example.b43_game_club.model.responses

import com.example.b43_game_club.model.supabase.Game
import com.example.b43_game_club.model.supabase.Genre
import com.example.b43_game_club.model.supabase.PurchasedPackages
import com.example.b43_game_club.model.supabase.User
import kotlinx.serialization.Serializable

@Serializable
data class GetAllPacks(
    var packs: MutableList<PurchasedPackages> = mutableListOf(),
    var users: MutableList<User> = mutableListOf(),
    var error: String = ""
)
