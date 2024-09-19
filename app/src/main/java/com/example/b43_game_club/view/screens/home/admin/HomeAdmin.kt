package com.example.b43_game_club.view.screens.home.admin

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.b43_game_club.model.supabase.PurchasedPackages
import com.example.b43_game_club.model.supabase.User
import com.example.b43_game_club.view.components.ContentCustomBox
import com.example.b43_game_club.view.components.SpacerHeight
import com.example.b43_game_club.view.components.TextTitleScreen
import com.example.b43_game_club.view.components.TittleCustomBox
import com.example.b43_game_club.view.screens.home.client.HomeViewModel
import com.example.b43_game_club.view.ui.theme.B43Theme
import com.example.b43_game_club.view.ui.theme.gradientBack
import com.example.b43_game_club.view.ui.theme.gradientButtonPinkBlue
import com.example.b43_game_club.view.ui.theme.gradientButtonPinkBlue40

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeAdmin(navHostController: NavHostController, viewModel: HomeAdminViewModel = hiltViewModel()) {

    val state = viewModel.state.collectAsState()
    viewModel.context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.launch()
    }

    Column(
        modifier = Modifier.fillMaxSize().background(B43Theme.colors.background).background(
            gradientBack
        ).verticalScroll(
            rememberScrollState()
        )) {
        Column(
            modifier = Modifier.padding(24.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextTitleScreen("СВОДКА")
            SpacerHeight(40.dp)
            FlowRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Box(modifier = Modifier.weight(1f).background(gradientButtonPinkBlue, RoundedCornerShape(15.dp)).padding(15.dp))
                {
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        TittleCustomBox("Часы посещения")
                        SpacerHeight(4.dp)
                        ContentCustomBox(state.value.sumHours)
                    }
                }
                Box(modifier = Modifier.weight(1f).background(gradientButtonPinkBlue, RoundedCornerShape(15.dp)).padding(15.dp))
                {
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        TittleCustomBox("Сумма выкупа")
                        SpacerHeight(4.dp)
                        ContentCustomBox(state.value.sumCost.toInt().toString() + " Р")
                    }
                }
            }
            SpacerHeight(20.dp)
            TextTitleScreen("История")
            SpacerHeight(30.dp)
            listHistory(state.value.listPurchasedPackages, state.value.listUsers)
        }

    }

}

@Composable
fun listHistory(list: List<PurchasedPackages>, users: List<User>) {
    var count = 1
    for (info in list) {
        Box(modifier = Modifier.fillMaxWidth().background(gradientButtonPinkBlue40, RoundedCornerShape(15.dp)).padding(horizontal = 20.dp, vertical = 10.dp)) {
            val user = users.find { it.id == info.idUser }
            val fio = "$count. ${user?.surname} ${user?.name} ${user?.patronymic}"
            Text(text = "${fio} приобрел пакет на ${info.hours} ч. за ${info.cost.toInt()} Р",
                style = B43Theme.typography.textInTextField.copy(color = B43Theme.colors.onPrimary))
        }
        SpacerHeight(8.dp)
        count++
    }
}