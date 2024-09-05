package com.example.b43_game_club.view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.Blue

@Composable
fun TextTitleScreen(text: String){
    Box {
        Text(
            text = text,
            style = B43Theme.typography.titleScreen,
            color = B43Theme.colors.onPrimary
        )
        Text(
            text = text,
            modifier = Modifier.offset(0.dp, 4.dp),
            style = B43Theme.typography.titleScreen,
            color = Color(Blue.value)
        )
    }
}