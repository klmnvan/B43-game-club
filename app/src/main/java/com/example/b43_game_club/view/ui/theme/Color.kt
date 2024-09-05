package com.example.b43_game_club.view.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Back = Color(0xFF292B2D)
val Containers = Color(0xFF171818)
val Pink = Color(0xFFFB00A9)
val Blue = Color(0xFF3B92FB)
val LightBlue = Color(0xFF03FDFD)
val White = Color(0xFFFFFFFF)
val Error = Color(0xFFEA001C)

val DarkColorScheme = darkColorScheme(
    background = Back,
    primaryContainer = Containers,
    onPrimary = White,
    onSecondary = White,
    primary = Blue,
    error = Error,
    surface = White,
)

val LocalColors = staticCompositionLocalOf { DarkColorScheme }