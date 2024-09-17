package com.example.b43_game_club.model.screens.supabase

import com.example.b43_game_club.model.screens.profile.ProfileState

data class GetUserProfileDataResponse(
    var profile: ProfileState? = ProfileState(),
    var error: String = ""
)
