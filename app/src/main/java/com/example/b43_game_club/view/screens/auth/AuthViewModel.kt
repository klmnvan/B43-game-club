package com.example.b43_game_club.view.screens.auth

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.b43_game_club.domain.network.SupabaseServiceImpl
import com.example.b43_game_club.model.screens.auth.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
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

}