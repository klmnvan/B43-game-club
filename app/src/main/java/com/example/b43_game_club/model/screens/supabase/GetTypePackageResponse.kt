package com.example.b43_game_club.model.screens.supabase

data class GetTypePackageResponse(
    var typePackages: MutableList<TypePackage> = mutableListOf(),
    var error: String = ""
)
