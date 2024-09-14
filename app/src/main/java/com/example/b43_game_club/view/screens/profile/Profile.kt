package com.example.b43_game_club.view.screens.profile

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.b43_game_club.view.components.GradientTextView
import com.example.b43_game_club.view.components.SpacerHeight
import com.example.b43_game_club.view.components.StandartTF
import com.example.b43_game_club.view.components.TextTitleScreen
import com.example.b43_game_club.view.components.TittleTextField
import com.example.b43_game_club.view.screens.auth.AuthViewModel
import com.example.b43_game_club.view.screens.home.items.ItemsGamePackage
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.gradientBack

@Composable
fun Profile(navHostController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()){

    val state = viewModel.state
    viewModel.context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(B43Theme.colors.background)
            .background(
                gradientBack
            )
            .verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()) {
            SpacerHeight(24.dp)
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                TextTitleScreen("Профиль")
                SpacerHeight(20.dp)
                Box(modifier = Modifier
                    .background(B43Theme.colors.primaryContainer, RoundedCornerShape(15.dp))
                    .size(100.dp))
                Text(
                    text = "Изменить",
                    style = B43Theme.typography.jostRegular20,
                    color = B43Theme.colors.primary
                )
            }
            SpacerHeight(8.dp)
            SpacerHeight(12.dp)
            TittleTextField("Роль")
            SpacerHeight(8.dp)
            SpacerHeight(12.dp)
            TittleTextField("Полное имя")
            SpacerHeight(8.dp)
            StandartTF("${state.name} ${state.surname} ${state.patronymic}",
                { var listString = listOf("", "", "")
                    viewModel.updateState(viewModel.state.copy(email = it))}, "user@mail.ru")
            SpacerHeight(12.dp)
            TittleTextField("Адрес эл. почты")
            SpacerHeight(8.dp)
            GradientTextView(state.email)
            SpacerHeight(12.dp)
            TittleTextField("Количество часов посещения")
            SpacerHeight(8.dp)
            GradientTextView(state.hours.toString() + " ч.")
            SpacerHeight(12.dp)
            TittleTextField("Сумма выкупа")
            GradientTextView(state.amountRansom.toString() + " руб.")
        }
    }

}