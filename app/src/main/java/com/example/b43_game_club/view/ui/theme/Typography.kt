package com.example.b43_game_club.view.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.b43_game_club.R

@Immutable
data class Typography(
    val titleScreen: TextStyle,
    val titleTextField: TextStyle,
    val textInTextField: TextStyle,
    val button: TextStyle,
    val jostRegular20: TextStyle,
)

val Jost = FontFamily(
    Font(R.font.jost_black, FontWeight.Black),
    Font(R.font.jost_bold, FontWeight.Bold),
    Font(R.font.jost_extra_bold, FontWeight.ExtraBold),
    Font(R.font.jost_extra_light, FontWeight.ExtraLight),
    Font(R.font.jost_light, FontWeight.Light),
    Font(R.font.jost_medium, FontWeight.Medium),
    Font(R.font.jost_regular, FontWeight.Normal),
    Font(R.font.jost_semi_bold, FontWeight.SemiBold),
    Font(R.font.jost_thin, FontWeight.Thin)
)

val Cyberpunk = FontFamily(
    Font(R.font.cyberpunk, FontWeight.Normal)
)

val typography = Typography(
    titleScreen = TextStyle(
        fontFamily = Cyberpunk,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp),
    titleTextField = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp),
    textInTextField = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = Jost,
        fontSize = 20.sp),
    jostRegular20 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = Jost,
        fontSize = 20.sp),
)

val LocalTypography = staticCompositionLocalOf { typography }

