package com.example.b43_game_club.view.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Back = Color(0xFF292B2D)
val Containers = Color(0xFF171818)
val Pink = Color(0xFFFB00A9)
val Blue = Color(0xFF3B92FB)
val Blue20 = Color(0x333B92FB)
val LightBlue = Color(0xFF03FDFD)
val White = Color(0xFFFFFFFF)
val White50 = Color(0x80FFFFFF)
val Error = Color(0xFFEA001C)

val gradientBack = Brush.linearGradient(
    0.0f to Back,
    500.0f to Blue20,
    start = Offset.Zero,
    end = Offset.Infinite
)

val gradientButtonPinkBlue = Brush.horizontalGradient(
    listOf(Color(Pink.value), Color(Blue.value))
)

val gradientButtonBluePink = Brush.horizontalGradient(
    listOf(Color(Blue.value), Color(Pink.value))
)


val DarkColorScheme = darkColorScheme(
    background = Back,
    primaryContainer = Containers,
    onPrimary = White,
    onSecondary = White,
    primary = Blue,
    error = Error,
    surface = White,
    onTertiary = White50
)

val LocalColors = staticCompositionLocalOf { DarkColorScheme }