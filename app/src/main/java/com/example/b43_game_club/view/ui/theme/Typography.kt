package com.example.b43_game_club.view.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class Typography(
    val titleScreen: TextStyle,
    val titleTextField: TextStyle,
    val placeholderTextField: TextStyle,
    val button: TextStyle
)

val typography = Typography(
    titleScreen = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp),
    titleTextField = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp),
    placeholderTextField = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp)
)

val LocalTypography = staticCompositionLocalOf { typography }

