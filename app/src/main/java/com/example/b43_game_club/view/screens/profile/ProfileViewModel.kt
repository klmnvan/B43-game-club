package com.example.b43_game_club.view.screens.profile

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.b43_game_club.domain.network.SupabaseServiceImpl
import com.example.b43_game_club.model.screens.auth.AuthState
import com.example.b43_game_club.model.screens.profile.ProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val service: SupabaseServiceImpl
): ViewModel() {

    private val _state = mutableStateOf(ProfileState())
    val state: ProfileState get() = _state.value

    fun updateState(newState: ProfileState) {
        _state.value = newState
    }

    @SuppressLint("StaticFieldLeak")
    lateinit var context: Context



}