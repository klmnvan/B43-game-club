package com.example.b43_game_club.domain.repository

import android.content.Context
import android.content.SharedPreferences

object PrefManager {
    private lateinit var spAct: SharedPreferences

    fun init(context: Context){
        spAct = context.getSharedPreferences("root", Context.MODE_PRIVATE)
    }

    var act: Int
        get() = spAct.getInt("act", 0)
        set(value) = spAct.edit().putInt("act", value).apply()


}