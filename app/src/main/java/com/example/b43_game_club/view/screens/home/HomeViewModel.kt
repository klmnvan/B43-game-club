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

    fun launch() {
        viewModelScope.launch {
            val getTypesPackageResponse = service.getTypePackages()
            if(getTypesPackageResponse.error == "") {
                state.typePackages = getTypesPackageResponse.typePackages
                Log.d("typePackages", state.typePackages.toString())
                val getPackagesResponse = service.getGamePackages()
                if(getPackagesResponse.error == ""){
                    state.gamePackages = getPackagesResponse.gamePackages
                    Log.d("gamePackages", state.gamePackages.toString())
                    val getGames = service.getGames()
                    if(getGames.error == ""){
                        state.games = getGames.games
                        state.genres = getGames.genres
                        Log.d("games", state.games.toString())
                        updateState(state.copy(groupedByFirstLetter = state.gamePackages.groupBy { it.idType }, typePackages = state.typePackages, games = state.games) )
                    } else showError(getGames.error)
                } else showError(getPackagesResponse.error)
            } else showError(getTypesPackageResponse.error)
        }
    }

    private fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}