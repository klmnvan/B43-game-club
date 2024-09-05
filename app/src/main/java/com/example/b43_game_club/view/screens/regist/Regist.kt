package com.example.b43_game_club.view.screens.regist

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
fun Regist(navHostController: NavHostController, viewModel: RegistViewModel = hiltViewModel()){

    val state = viewModel.state
    viewModel.context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().background(B43Theme.colors.background).background(
            gradientBack
        ).verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center) {
        Column(modifier = Modifier.padding(horizontal = 24.dp).padding(vertical = 30.dp)) {
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) { TextTitleScreen("Регистрация") }
            SpacerHeight(30.dp)
            TittleTextField("Имя")
            SpacerHeight(8.dp)
            StandartTF(state.name, { viewModel.updateState(viewModel.state.copy(name = it))}, "Иван")
            SpacerHeight(12.dp)
            TittleTextField("Фамилия")
            SpacerHeight(8.dp)
            StandartTF(state.surname, { viewModel.updateState(viewModel.state.copy(surname = it))}, "Иванов")
            SpacerHeight(12.dp)
            TittleTextField("Отчество")
            SpacerHeight(8.dp)
            StandartTF(state.patronymic, { viewModel.updateState(viewModel.state.copy(patronymic = it))}, "Иванович")
            SpacerHeight(12.dp)
            TittleTextField("Адрес эл. почты")
            SpacerHeight(8.dp)
            StandartTF(state.email, { viewModel.updateState(viewModel.state.copy(email = it))}, "user@mail.ru")
            SpacerHeight(12.dp)
            TittleTextField("Пароль")
            SpacerHeight(8.dp)
            PasswordTF(state.password, { viewModel.updateState(viewModel.state.copy(password = it))}, "********")
            SpacerHeight(12.dp)
            TittleTextField("Подтвердите пароль")
            SpacerHeight(8.dp)
            PasswordTF(state.passwordConfirm, { viewModel.updateState(viewModel.state.copy(passwordConfirm = it))}, "********")
            SpacerHeight(40.dp)
            ButtonPinkBlue("Далее", {}, true)
            SpacerHeight(12.dp)
            ButtonBluePink("Авторизация", { viewModel.goAuth(navHostController) }, true)
        }
    }
}