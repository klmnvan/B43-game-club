package com.example.b43_game_club.view.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.b43_game_club.R
import com.example.b43_game_club.view.ui.theme.B43Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandartTF(value: String, input: (String) -> Unit, placeholder: String, clickOnIcon: () -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = {input(it) },
        textStyle = B43Theme.typography.textInTextField.copy(color = B43Theme.colors.onPrimary),
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp, shape = RoundedCornerShape(30), spotColor = Color(
                    Black.value
                )
            ),
        placeholder = { Text(text = placeholder, style = B43Theme.typography.textInTextField.copy(color = B43Theme.colors.onTertiary)) },
        singleLine = true,
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            containerColor = B43Theme.colors.primaryContainer,
            cursorColor = B43Theme.colors.primary
        )
    )
}
