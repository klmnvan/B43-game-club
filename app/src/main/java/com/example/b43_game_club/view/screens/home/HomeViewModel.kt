package com.example.b43_game_club.view.screens.home

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.b43_game_club.domain.network.SupabaseServiceImpl
import com.example.b43_game_club.model.screens.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val service: SupabaseServiceImpl
) : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: HomeState get() = _state.value

    fun updateState(newState: HomeState) {
        _state.value = newState
    }

    @SuppressLint("StaticFieldLeak")
    lateinit var context: Context

    @Suppress("NAME_SHADOWING")
    fun launch() {
        viewModelScope.launch {
            val response = service.getTypePackages()
            if(response.error == "") {
                state.typePackages = response.typePackages
                val response = service.getGamePackages()
                Log.d("typePackages", state.typePackages.toString())
                if(response.error == ""){
                    state.gamePackages = response.gamePackages
                    updateState(state.copy(groupedByFirstLetter = state.gamePackages.groupBy { it.idType }, typePackages = state.typePackages) )
                    Log.d("gamePackages", state.gamePackages.toString())
                } else {
                    Toast.makeText(context, response.error, Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, response.error, Toast.LENGTH_SHORT).show()
            }
        }
    }

}