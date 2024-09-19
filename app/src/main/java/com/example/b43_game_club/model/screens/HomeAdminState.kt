package com.example.b43_game_club.model.screens

import com.example.b43_game_club.model.supabase.PurchasedPackages
import com.example.b43_game_club.model.supabase.User

data class HomeAdminState(
    var listPurchasedPackages: MutableList<PurchasedPackages> = mutableListOf(),
    var listUsers: MutableList<User> = mutableListOf(),
    var sumHours: String = "0",
    var sumCost: String = "0",
)
