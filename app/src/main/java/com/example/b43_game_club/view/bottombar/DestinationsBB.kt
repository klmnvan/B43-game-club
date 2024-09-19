package com.example.b43_game_club.view.bottombar

import com.example.b43_game_club.R
import com.example.b43_game_club.domain.navigation.NavigationRoutes

sealed class DestinationsBB(
    val route: String,
    val title: String? = null,
    val resourceId: Int? = null
) {

    object HomeScreen : DestinationsBB(
        route = NavigationRoutes.HOME,
        title = "Главная",
        resourceId = R.drawable.icon_fire
    )

    object CreateOrderScreen : DestinationsBB(
        route = NavigationRoutes.CREATEORDER,
        title = null,
        resourceId = R.drawable.icon_plus
    )

    object ProfileScreen : DestinationsBB(
        route = NavigationRoutes.PROFILE,
        title = "Профиль",
        resourceId = R.drawable.icon_profile
    )

}