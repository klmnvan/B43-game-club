package com.example.b43_game_club.view.screens.createorder.Items

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.b43_game_club.view.components.SpacerHeight
import com.example.b43_game_club.view.components.TittleTextField
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.gradientButtonPinkBlue40

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType")
@Composable
fun DropDownMenu(
    value: String, list: List<String>, placeholder: String, input: (String) -> Unit){
    var expanded by remember { mutableStateOf(false) }
    Column {
        TittleTextField(placeholder)
        SpacerHeight(8.dp)
        Text(text = if(value == "") "Не выбрано" else value,
            modifier = Modifier.fillMaxWidth()
                .background(gradientButtonPinkBlue40, RoundedCornerShape(15.dp))
                .padding(vertical = 14.dp, horizontal = 20.dp)
                .clickable(interactionSource = remember { MutableInteractionSource() },indication = null) {
                    expanded = !expanded },
            style = B43Theme.typography.textInTextField.copy(color = B43Theme.colors.onPrimary),
        )
        DropdownMenu(
            modifier = Modifier.background(B43Theme.colors.primaryContainer),
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            list.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item, style = B43Theme.typography.textInTextField.copy(color = B43Theme.colors.onTertiary)) },
                    onClick = {
                        input(item)
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    colors = MenuDefaults.itemColors(Black)
                )
            }
        }
    }

}

@Composable
fun TextCost(text: String){
    Text(
        text = buildAnnotatedString {
            withStyle(SpanStyle(color = B43Theme.colors.secondary, fontWeight = FontWeight.Bold)) {
                append("ЦЕНА: ")
            }
            withStyle(SpanStyle(color = B43Theme.colors.onPrimary, fontWeight = FontWeight.Medium)) {
                append(text + " Р")
            }
        },
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Left,
        style = B43Theme.typography.titleTextField.copy(fontSize = 20.sp)
    )
}