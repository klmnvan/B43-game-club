package com.example.b43_game_club.view.screens.auth

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.b43_game_club.domain.navigation.NavigationRoutes
import com.example.b43_game_club.domain.network.SupabaseServiceImpl
import com.example.b43_game_club.domain.repository.PrefManager
import com.example.b43_game_club.model.screens.auth.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val service: SupabaseServiceImpl
) : ViewModel() {

    private val _state = mutableStateOf(AuthState())
    val state: AuthState get() = _state.value

    fun updateState(newState: AuthState) {
        _state.value = newState
    }

    @SuppressLint("StaticFieldLeak")
    lateinit var context: Context

    fun goRegist(navHostController: NavHostController) {
        navHostController.navigate(NavigationRoutes.REGIST) {
            popUpTo(NavigationRoutes.AUTH){
                inclusive = true
            }
        }
    }

    fun signIn(navHostController: NavHostController) {
        if(state.email != "" && state.password != "") {
            viewModelScope.launch {
                val response = service.signIn(state.email, state.password)
                if(response.error == "") {
                    PrefManager.act = 1
                    navHostController.navigate(NavigationRoutes.HOME) {
                        popUpTo(NavigationRoutes.AUTH) {
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