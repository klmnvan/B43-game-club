package com.example.b43_game_club.view.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.b43_game_club.view.components.BlueTextView
import com.example.b43_game_club.view.components.ButtonPink
import com.example.b43_game_club.view.components.ContentCustomBox
import com.example.b43_game_club.view.components.GradientTextView
import com.example.b43_game_club.view.components.SpacerHeight
import com.example.b43_game_club.view.components.StandartTF
import com.example.b43_game_club.view.components.TextTitleScreen
import com.example.b43_game_club.view.components.TittleCustomBox
import com.example.b43_game_club.view.components.TittleTextField
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.gradientBack
import com.example.b43_game_club.view.ui.theme.gradientButtonPinkBlue

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Profile(viewModel: ProfileViewModel = hiltViewModel()){

    val state = viewModel.state.collectAsState()
    viewModel.context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.getProfile()
    }

    Column(
        modifier = Modifier.fillMaxSize().background(B43Theme.colors.background)
            .background(gradientBack).verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                TextTitleScreen("Профиль")
                SpacerHeight(20.dp)
            }
            SpacerHeight(8.dp)
            SpacerHeight(12.dp)
            TittleTextField("Роль")
            SpacerHeight(8.dp)
            BlueTextView(state.value.role)
            SpacerHeight(12.dp)
            TittleTextField("Фамилия")
            SpacerHeight(8.dp)
            StandartTF(state.value.surname, { viewModel.stateValue = state.value.copy(surname = it)}, "Иванов")
            SpacerHeight(12.dp)
            TittleTextField("Имя")
            SpacerHeight(8.dp)
            StandartTF(state.value.name, { viewModel.stateValue = state.value.copy(name = it)}, "Иван")
            SpacerHeight(12.dp)
            TittleTextField("Отчество")
            SpacerHeight(8.dp)
            StandartTF(state.value.patronymic, { viewModel.stateValue = state.value.copy(patronymic = it)}, "Иванович")
            SpacerHeight(12.dp)
            TittleTextField("Адрес эл. почты")
            SpacerHeight(8.dp)
            GradientTextView(state.value.email)
            SpacerHeight(20.dp)
            FlowRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Box(modifier = Modifier.weight(1f).background(gradientButtonPinkBlue, RoundedCornerShape(15.dp)).padding(15.dp))
                {
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        TittleCustomBox("Часы посещения")
                        SpacerHeight(4.dp)
                        ContentCustomBox(state.value.hours.toString())
                    }
                }
                Box(modifier = Modifier.weight(1f).background(gradientButtonPinkBlue, RoundedCornerShape(15.dp)).padding(15.dp))
                {
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        TittleCustomBox("Сумма выкупа")
                        SpacerHeight(4.dp)
                        ContentCustomBox(state.value.amountRansom.toInt().toString() + " Р")
                    }
                }
            }
            SpacerHeight(30.dp)
            ButtonPink("Сохранить", true) { viewModel.saveProfile() }
        }
    }

}