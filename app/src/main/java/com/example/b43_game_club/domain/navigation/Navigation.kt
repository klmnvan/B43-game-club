package com.example.b43_game_club.domain.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.b43_game_club.view.screens.auth.Auth
import com.example.b43_game_club.view.screens.regist.Regist
import com.example.b43_game_club.view.screens.splash.Splash

@Composable
fun Navigation() {
    val controller = rememberNavController()
    NavHost(
        navController = controller,
        startDestination = NavigationRoutes.SPLASH) {

        composable(NavigationRoutes.SPLASH){
            Splash(controller)
        }
        composable(NavigationRoutes.AUTH){
            Auth(controller)
        }
        composable(NavigationRoutes.REGIST){
            Regist(controller)
        }

    }
}