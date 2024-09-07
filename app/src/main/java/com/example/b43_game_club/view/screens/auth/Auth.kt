package com.example.b43_game_club.view.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.b43_game_club.view.components.ButtonBluePink
import com.example.b43_game_club.view.components.ButtonPinkBlue
import com.example.b43_game_club.view.components.PasswordTF
import com.example.b43_game_club.view.components.SpacerHeight
import com.example.b43_game_club.view.components.StandartTF
import com.example.b43_game_club.view.components.TextTitleScreen
import com.example.b43_game_club.view.components.TittleTextField
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.gradientBack

@Composable
fun Auth(navHostController: NavHostController, viewModel: AuthViewModel = hiltViewModel()) {

    val state = viewModel.state
    viewModel.context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().background(B43Theme.colors.background).background(
            gradientBack).verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center) {
        Column(modifier = Modifier.padding(horizontal = 24.dp).padding(vertical = 30.dp)) {
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) { TextTitleScreen("Авторизация") }
            SpacerHeight(30.dp)
            TittleTextField("Адрес эл. почты")
            SpacerHeight(8.dp)
            StandartTF(state.email, { viewModel.updateState(viewModel.state.copy(email = it))}, "user@mail.ru")
            SpacerHeight(20.dp)
            TittleTextField("Пароль")
            SpacerHeight(8.dp)
            PasswordTF(state.password, { viewModel.updateState(viewModel.state.copy(password = it))}, "user@mail.ru")
            SpacerHeight(60.dp)
            ButtonPinkBlue("Далее", { viewModel.signIn(navHostController) }, state.password != "" && state.email != "")
            SpacerHeight(8.dp)
            ButtonBluePink("Регистрация", { viewModel.goRegist(navHostController) }, true)
        }
    }

}