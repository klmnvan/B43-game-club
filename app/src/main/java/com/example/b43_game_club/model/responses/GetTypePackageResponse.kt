package com.example.b43_game_club.model.responses

import com.example.b43_game_club.model.supabase.TypePackage

data class GetTypePackageResponse(
    var typePackages: MutableList<TypePackage> = mutableListOf(),
    var error: String = ""
)
