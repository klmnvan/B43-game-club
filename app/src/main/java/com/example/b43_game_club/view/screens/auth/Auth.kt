package com.example.b43_game_club.view.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.b43_game_club.view.ui.theme.B43Theme

@Composable
fun Auth(navHostController: NavHostController, viewModel: AuthViewModel = hiltViewModel()) {
    val state = viewModel.state
    viewModel.context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().background(B43Theme.colors.background).verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center) {
        Column(modifier = Modifier.padding(horizontal = 24.dp).padding(vertical = 30.dp)) {

        }
    }

}