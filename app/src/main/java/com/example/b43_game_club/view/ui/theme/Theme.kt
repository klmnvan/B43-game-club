package com.example.b43_game_club.view.ui.theme

import android.util.Log
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ReadOnlyComposable

object B43Theme {
    val typography: Typography
        @ReadOnlyComposable
        @Composable
        get() = LocalTypography.current
    val colors: ColorScheme
        @ReadOnlyComposable
        @Composable
        get() = LocalColors.current
}

@Composable
fun B43Theme(
    themeMode: ThemeMode = ThemeMode.Dark,
    typography: Typography = B43Theme.typography,
    content: @Composable () -> Unit
) {
    Log.d("NewsTheme -> ", "Theme mode changed to $themeMode")
    val colors = when (themeMode) {
        ThemeMode.Dark -> DarkColorScheme
    }
    LaunchedEffect(key1 = colors){
        Log.d("NewsTheme -> ", "Colors changed")
    }
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography
    ){
        content()
    }
}

sealed class ThemeMode(val title: String) {
    data object Dark: ThemeMode(title = "Dark")
}
