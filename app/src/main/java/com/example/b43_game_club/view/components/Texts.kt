package com.example.b43_game_club.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.Blue
import com.example.b43_game_club.view.ui.theme.gradientButtonPinkBlue40

@Composable
fun TextTitleScreen(text: String){
    Box {
        Text(
            text = text.toUpperCase(),
            modifier = Modifier.offset(0.dp, 4.dp),
            style = B43Theme.typography.titleScreen,
            color = Color(Blue.value),
            textAlign = TextAlign.Center
        )
        Text(
            text = text.toUpperCase(),
            style = B43Theme.typography.titleScreen,
            color = B43Theme.colors.onPrimary,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TittleTextField(text: String){
    Text(
        text = text,
        style = B43Theme.typography.titleTextField,
        color = B43Theme.colors.onPrimary
    )
}

@Composable
fun TittleCustomBox(text: String){
    Text(
        text = text,
        style = B43Theme.typography.titleTextField.copy(fontWeight = FontWeight.Bold, fontSize = 3.2.em),
        color = B43Theme.colors.onPrimary
    )
}

@Composable
fun ContentCustomBox(text: String){
    Text(
        text = text,
        style = B43Theme.typography.titleTextField.copy(fontWeight = FontWeight.Bold, fontSize = 32.sp),
        color = B43Theme.colors.onPrimary
    )
}

@Composable
fun GradientTextView(text: String) {
    Text(text = text,
        modifier = Modifier.fillMaxWidth()
            .background(gradientButtonPinkBlue40, RoundedCornerShape(15.dp))
            .padding(vertical = 14.dp, horizontal = 20.dp),
        style = B43Theme.typography.textInTextField.copy(color = B43Theme.colors.onPrimary),
    )
}

@Composable
fun BlueTextView(text: String) {
    Text(text = text,
        modifier = Modifier.fillMaxWidth()
            .background(B43Theme.colors.primary, RoundedCornerShape(15.dp))
            .padding(vertical = 14.dp, horizontal = 20.dp),
        style = B43Theme.typography.textInTextField.copy(color = B43Theme.colors.onPrimary),
    )
}
