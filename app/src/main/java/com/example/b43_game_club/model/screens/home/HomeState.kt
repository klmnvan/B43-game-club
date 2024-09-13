package com.example.b43_game_club.model.screens.home

import com.example.b43_game_club.model.screens.supabase.GamePackage
import com.example.b43_game_club.model.screens.supabase.TypePackage

data class HomeState(
    var products: List<String> = listOf(""),
    var gamePackages: MutableList<GamePackage> = mutableListOf(),
    var typePackages: MutableList<TypePackage> = mutableListOf(),
    val groupedByFirstLetter: Map<Int, List<GamePackage>> = mapOf()
)
