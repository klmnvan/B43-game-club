package com.example.b43_game_club.view.bottombar

import com.example.b43_game_club.R

sealed class DestinationsBB(
    val route: String,
    val title: String? = null,
    val resourceId: Int? = null
) {

    object HomeScreen : DestinationsBB(
        route = "home",
        title = "Главная",
        resourceId = R.drawable.icon_fire
    )

    object CreateOrderScreen : DestinationsBB(
        route = "create_order",
        title = null,
        resourceId = R.drawable.icon_plus
    )

    object ProfileScreen : DestinationsBB(
        route = "profile",
        title = "Профиль",
        resourceId = R.drawable.icon_profile
    )

}