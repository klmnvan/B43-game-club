package com.example.b43_game_club.model.responses

import com.example.b43_game_club.model.screens.ProfileState

data class GetUserProfileDataResponse(
    var profile: ProfileState? = ProfileState(),
    var error: String = ""
)
