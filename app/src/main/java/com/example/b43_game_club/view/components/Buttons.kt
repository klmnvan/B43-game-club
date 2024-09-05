@file:Suppress("CAST_NEVER_SUCCEEDS")

package com.example.b43_game_club.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.White
import com.example.b43_game_club.view.ui.theme.gradientButtonBluePink
import com.example.b43_game_club.view.ui.theme.gradientButtonPinkBlue

@Composable
fun ButtonPinkBlue(text: String, onClick: () -> Unit, enabled: Boolean = true) {
    Box(modifier = Modifier.fillMaxWidth().background(gradientButtonPinkBlue, RoundedCornerShape(15.dp)),) {
        Button(
            onClick = { onClick() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(White.value),
                containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color(White.value)
            ),
            shape = RoundedCornerShape(15.dp),
            enabled = enabled
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(vertical = 8.dp),
                style = B43Theme.typography.button,
                color = Color.White
            )
        }
    }
}

@Composable
fun ButtonBluePink(text: String, onClick: () -> Unit, enabled: Boolean = true) {
    Box(modifier = Modifier.fillMaxWidth().background(gradientButtonBluePink, RoundedCornerShape(15.dp)),) {
        Button(
            onClick = { onClick() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color(White.value),
                containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color(White.value)
            ),
            shape = RoundedCornerShape(15.dp),
            enabled = enabled
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(vertical = 8.dp),
                style = B43Theme.typography.button,
                color = Color.White
            )
        }
    }
}