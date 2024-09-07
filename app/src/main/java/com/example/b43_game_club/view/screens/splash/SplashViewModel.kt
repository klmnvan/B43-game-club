package com.example.b43_game_club.view.screens.splash

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.b43_game_club.domain.navigation.NavigationRoutes
import com.example.b43_game_club.domain.repository.PrefManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    @SuppressLint("StaticFieldLeak")
    lateinit var context: Context

    fun launch(navController: NavHostController, configuration: Configuration) {
        viewModelScope.launch {
            if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                delay(1500L)
                if (PrefManager.act == 0){
                    navController.navigate(NavigationRoutes.AUTH) {
                        popUpTo(NavigationRoutes.SPLASH) {
                            inclusive = true
                        }
                    }
                }
                /* if (PrefManager.act == 1){
                     navController.navigate(NavigationRoutes.SPLASH) {
                         popUpTo(NavigationRoutes.AUTH) {
                             inclusive = true
                         }
                     }
                 }*/
            }
        }
    }
}