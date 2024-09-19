package com.example.b43_game_club.view.screens.createorder

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.b43_game_club.domain.repository.General
import com.example.b43_game_club.view.components.ButtonPink
import com.example.b43_game_club.view.components.SpacerHeight
import com.example.b43_game_club.view.components.TextTitleScreen
import com.example.b43_game_club.view.screens.createorder.Items.DropDownMenu
import com.example.b43_game_club.view.screens.createorder.Items.TextCost
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.gradientBack

@Composable
fun CreateOrder(navHostController: NavHostController, viewModel: CreateOrderViewModel = hiltViewModel()){

    val state = viewModel.state.collectAsState()
    viewModel.context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.launch()
    }

    LaunchedEffect(state.value.hour, state.value.type) {
        if(state.value.hour != "" && state.value.type != ""){
            val idType = General.typePackages.find { it.name == state.value.type }!!.id
            viewModel.stateValue = state.value.copy(cost = General.gamePackages.find { it.idType == idType && it.time == state.value.hour.toInt() }!!.price)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().background(B43Theme.colors.background).background(
            gradientBack
        ).verticalScroll(
            rememberScrollState()
        )) {
        Column(modifier = Modifier.padding(24.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                TextTitleScreen("ПОКУПКА ПАКЕТА")
            }
            SpacerHeight(40.dp)
            DropDownMenu(state.value.hour, state.value.listHours, "Количество часов") {
                viewModel.stateValue = state.value.copy(hour = it)
            }
            SpacerHeight(12.dp)
            DropDownMenu(state.value.type, state.value.listTypes, "Зона") {
                viewModel.stateValue = state.value.copy(type = it)
            }
            SpacerHeight(20.dp)
            TextCost(state.value.cost.toString())
            SpacerHeight(30.dp)
            ButtonPink("Купить") {
                viewModel.buyPackage(navHostController)
            }
        }
    }

}