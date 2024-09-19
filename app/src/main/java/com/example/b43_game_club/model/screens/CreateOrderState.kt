package com.example.b43_game_club.model.screens

data class CreateOrderState(
    var listHours: List<String> = listOf(),
    var hour: String = "",
    var listTypes: List<String> = listOf(),
    var type: String = "",
    var cost: Int = 0,
)
