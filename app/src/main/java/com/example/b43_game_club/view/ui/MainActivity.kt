package com.example.b43_game_club.view.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.b43_game_club.domain.navigation.Navigation
import com.example.b43_game_club.domain.repository.PrefManager
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.ThemeMode
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrefManager.init(LocalContext.current)
            B43Theme(themeMode = ThemeMode.Dark) {
                Scaffold(
                    modifier = Modifier.fillMaxSize().background(B43Theme.colors.background),
                    /*bottomBar = {
                        if (isBottomBarVisible.value) {
                            BottomBar(
                                navController = controller,
                            )
                        }
                    }*/) { paddingValues ->
                    Box(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        Navigation()
                    }
                }
            }
        }
    }
}
