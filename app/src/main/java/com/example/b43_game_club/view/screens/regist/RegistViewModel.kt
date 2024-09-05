package com.example.b43_game_club.view.screens.regist

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.b43_game_club.domain.navigation.NavigationRoutes
import com.example.b43_game_club.domain.network.SupabaseServiceImpl
import com.example.b43_game_club.model.screens.regist.RegistState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistViewModel @Inject constructor(
    private val service: SupabaseServiceImpl
) : ViewModel() {

    private val _state = mutableStateOf(RegistState())
    val state: RegistState get() = _state.value

    fun updateState(newState: RegistState) {
        _state.value = newState
    }

    @SuppressLint("StaticFieldLeak")
    lateinit var context: Context

    fun goAuth(navHostController: NavHostController) {
        navHostController.navigate(NavigationRoutes.AUTH) {
            popUpTo(NavigationRoutes.REGIST){

            }
        }
    }

}