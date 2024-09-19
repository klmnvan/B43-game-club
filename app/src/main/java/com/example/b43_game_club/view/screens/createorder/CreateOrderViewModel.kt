package com.example.b43_game_club.view.screens.createorder

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.b43_game_club.domain.navigation.NavigationRoutes
import com.example.b43_game_club.domain.network.SupabaseServiceImpl
import com.example.b43_game_club.domain.repository.General
import com.example.b43_game_club.model.screens.CreateOrderState
import com.example.b43_game_club.model.supabase.PurchasedPackages
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateOrderViewModel @Inject constructor(
    private val service: SupabaseServiceImpl
) : ViewModel() {

    private val _state = MutableStateFlow(CreateOrderState())
    val state: StateFlow<CreateOrderState> get() = _state.asStateFlow()

    var stateValue: CreateOrderState
        get() = state.value
        set(value) {
            _state.value = value
        }

    @SuppressLint("StaticFieldLeak")
    lateinit var context: Context

    fun launch() {
        stateValue = stateValue.copy(listHours = General.gamePackages.map { it.time.toString() }.distinct())
        stateValue = stateValue.copy(listTypes = General.typePackages.map { it.name })

        if(stateValue.listHours.isNotEmpty() && stateValue.listTypes.isNotEmpty()){
            stateValue = stateValue.copy(hour = stateValue.listHours[0], type = stateValue.listTypes[0])
        }
        Log.e("menu", stateValue.toString())
        Log.e("menu", General.gamePackages.toString())
        Log.e("menu", General.typePackages.toString())
    }

    fun buyPackage(navHostController: NavHostController){
        if(stateValue.hour != "" && stateValue.type != ""){
            viewModelScope.launch {
                    val response = service.insertPurchasedPackage(PurchasedPackages(hours = stateValue.hour.toInt(), cost = stateValue.cost.toFloat()))
                    if(response.error == "") {
                        Toast.makeText(context, "Успешно", Toast.LENGTH_SHORT).show()
                        navHostController.navigate(NavigationRoutes.HOME) {
                            popUpTo(NavigationRoutes.CREATEORDER) {
                                inclusive = true
                            }
                        }
                    } else {
                        Toast.makeText(context, response.error, Toast.LENGTH_SHORT).show()
                    }

            }
        }
    }

}