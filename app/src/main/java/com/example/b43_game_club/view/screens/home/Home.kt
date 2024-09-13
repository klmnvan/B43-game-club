package com.example.b43_game_club.view.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.b43_game_club.model.screens.supabase.GamePackage
import com.example.b43_game_club.view.components.SpacerHeight
import com.example.b43_game_club.view.components.TextTitleScreen
import com.example.b43_game_club.view.screens.home.items.ItemsGamePackage
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.gradientBack

@Composable
fun Home(navHostController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val state = viewModel.state
    viewModel.context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.launch()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(B43Theme.colors.background)
            .background(
                gradientBack
            )
            .verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.padding(horizontal = 24.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            SpacerHeight(24.dp)
            TextTitleScreen("Прайслист")
            SpacerHeight(60.dp)
            ItemsGamePackage(state.groupedByFirstLetter, state.typePackages)
        }


        
    }

}