package com.example.b43_game_club.domain.repository

import com.example.b43_game_club.model.supabase.GamePackage
import com.example.b43_game_club.model.supabase.TypePackage

object General {
    var typePackages: MutableList<TypePackage> = mutableListOf()
    var gamePackages: MutableList<GamePackage> = mutableListOf()
}