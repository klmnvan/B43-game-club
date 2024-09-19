package com.example.b43_game_club.view.screens.profile

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.b43_game_club.domain.navigation.NavigationRoutes
import com.example.b43_game_club.domain.network.SupabaseServiceImpl
import com.example.b43_game_club.model.screens.ProfileState
import com.example.b43_game_club.model.supabase.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val service: SupabaseServiceImpl
): ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> get() = _state.asStateFlow()

    var actualProfile = User()

    var stateValue: ProfileState
        get() = _state.value
        set(value) {
            _state.value = value
        }

    @SuppressLint("StaticFieldLeak")
    lateinit var context: Context

    fun getProfile() {
        viewModelScope.launch {
            val response = service.getUserProfileData()
            if(response.error == "") {
                val profile = response.profile
                actualProfile = User(id = profile!!.id, name = profile.name, surname = profile.surname, patronymic = profile.patronymic)
                stateValue = response.profile!!
            } else {
                Toast.makeText(context, response.error, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun saveProfile() {
        if(!(actualProfile.name == stateValue.name && actualProfile.surname == stateValue.surname && actualProfile.patronymic == stateValue.patronymic)){
            viewModelScope.launch {
                val response = service.updateProfile(stateValue.name, stateValue.surname, stateValue.patronymic)
                if(response.error == "") {
                    Toast.makeText(context, "Профиль успешно изменён", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, response.error, Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(context, "Сохранять нечего", Toast.LENGTH_SHORT).show()
        }
    }

    fun logOut(navHostController: NavHostController) {
        viewModelScope.launch {
            service.logOut()
            navHostController.popBackStack()
            navHostController.navigate(NavigationRoutes.AUTH) {
                popUpTo(NavigationRoutes.PROFILE) {
                    inclusive = true
                }
            }
        }
    }


}