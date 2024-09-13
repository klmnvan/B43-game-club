package com.example.b43_game_club.view.screens.home.items

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReusableComposeNode
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.b43_game_club.model.screens.supabase.GamePackage
import com.example.b43_game_club.model.screens.supabase.TypePackage
import com.example.b43_game_club.view.components.SpacerHeight
import com.example.b43_game_club.view.components.SpacerWidth
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.Back
import com.example.b43_game_club.view.ui.theme.White
import com.example.b43_game_club.view.ui.theme.gradientButtonPinkBlue
import com.example.b43_game_club.view.ui.theme.gradientButtonPinkBlue40

@Composable
fun ItemsGamePackage(gamePackages: Map<Int, List<GamePackage>>, types: List<TypePackage>) {
    Log.d("sdfsdf", gamePackages.toString())
    Log.d("types", types.toString())
    for (type in gamePackages.keys) {
        Row (modifier = Modifier.fillMaxWidth().background(gradientButtonPinkBlue40, RoundedCornerShape(15.dp)).padding(40.dp)) {
            Column {
                for (gPackage in gamePackages.getValue(type)) {
                    TextDesc(gPackage.time.toString() + "ч.")
                }
            }
            SpacerWidth(20.dp)
            
            SpacerWidth(20.dp)
            Column {
                for (gPackage in gamePackages.getValue(type)) {
                    TextDesc(gPackage.price.toString() + "руб.")
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center // Center content vertically
            ) {
                Text(
                    modifier = Modifier
                        .rotate(90f),
                    text = types.find { it.id == type }!!.name.toUpperCase(),
                    style = B43Theme.typography.titleTextField.copy(fontWeight = FontWeight.Bold),
                    color = B43Theme.colors.onPrimary,
                    textAlign = TextAlign.Center
                )
            }
        }
        SpacerHeight(12.dp)
    }
}

@Composable
fun TextDesc(text: String) {
    Text(
        text = text,
        style = B43Theme.typography.titleTextField.copy(fontWeight = FontWeight.Bold),
        color = B43Theme.colors.onPrimary
    )
}