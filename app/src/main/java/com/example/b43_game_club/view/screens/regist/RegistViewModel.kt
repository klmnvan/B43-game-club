package com.example.b43_game_club.view.screens.regist

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.b43_game_club.domain.navigation.NavigationRoutes
import com.example.b43_game_club.domain.network.SupabaseServiceImpl
import com.example.b43_game_club.model.screens.RegistState
import com.example.b43_game_club.model.supabase.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
                inclusive = true
            }
        }
    }

    fun signIn(navHostController: NavHostController) {
        if(state.email != "" && state.password != "" && state.name != ""
            && state.surname != "" && state.patronymic != "" && state.passwordConfirm != "") {
            viewModelScope.launch {
                var response = service.signUp(state.email, state.password)
                if(response.error == "") {
                    response = service.addUser(User("", state.name, state.surname, state.patronymic, idRole = 1))
                    if(response.error == "") {
                        navHostController.navigate(NavigationRoutes.AUTH) {
                            popUpTo(NavigationRoutes.REGIST) {
                                inclusive = true
                            }
                        }
                    } else {
                        Toast.makeText(context, response.error, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, response.error, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}