package com.example.b43_game_club.domain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.b43_game_club.view.screens.profile.Profile
import com.example.b43_game_club.view.screens.auth.Auth
import com.example.b43_game_club.view.screens.home.Home
import com.example.b43_game_club.view.screens.regist.Regist
import com.example.b43_game_club.view.screens.splash.Splash

@Composable
fun Navigation(controller: NavHostController, visibleBBar: MutableState<Boolean>) {
    NavHost(
        navController = controller,
        startDestination = NavigationRoutes.PROFILE) {

        composable(NavigationRoutes.SPLASH){
            Splash(controller)
        }
        composable(NavigationRoutes.AUTH){
            visibleBBar.value = false
            Auth(controller)
        }
        composable(NavigationRoutes.REGIST){
            Regist(controller)
        }
        composable(NavigationRoutes.HOME){
            visibleBBar.value = true
            Home(controller)
        }
        composable(NavigationRoutes.PROFILE){
            Profile(controller)
        }
        composable(NavigationRoutes.CREATEORDER){
            //CreateOrder(controller)
        }

    }
}