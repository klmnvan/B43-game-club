package com.example.b43_game_club.view.screens.home.admin

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.b43_game_club.domain.navigation.NavigationRoutes
import com.example.b43_game_club.domain.network.SupabaseServiceImpl
import com.example.b43_game_club.model.screens.CreateOrderState
import com.example.b43_game_club.model.screens.HomeAdminState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeAdminViewModel @Inject constructor(
    private val service: SupabaseServiceImpl
) : ViewModel() {

    private val _state = MutableStateFlow(HomeAdminState())
    val state: StateFlow<HomeAdminState> get() = _state.asStateFlow()

    var stateValue: HomeAdminState
        get() = state.value
        set(value) {
            _state.value = value
        }

    @SuppressLint("StaticFieldLeak")
    lateinit var context: Context

    fun launch() {
        viewModelScope.launch {
            viewModelScope.launch {
                val response = service.getAllPacks()
                if(response.error == "") {
                    if(response.packs.isNotEmpty()){
                        stateValue = stateValue.copy(listPurchasedPackages = response.packs,
                            listUsers = response.users,
                            sumCost = response.packs.sumOf { it.cost.toInt() }.toString(),
                            sumHours = response.packs.sumOf { it.hours }.toString())
                    }
                } else {
                    Toast.makeText(context, response.error, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}