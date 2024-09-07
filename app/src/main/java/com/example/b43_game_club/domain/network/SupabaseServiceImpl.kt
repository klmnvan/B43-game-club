package com.example.b43_game_club.domain.network

import android.util.Log
import com.example.b43_game_club.model.screens.Response
import com.example.b43_game_club.model.screens.supabase.User
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.from

class SupabaseServiceImpl(private val client: SupabaseClient): SupabaseService {

    override suspend fun signIn(email: String, password: String): Response {
        return try {
            val response = client.auth.signInWith(Email){
                this.email = email
                this.password = password
            }
            Response(response.toString())
        } catch (e: Exception) {
            Log.d("error sign in", e.message.toString())
            Response("", e.message.toString())
        }
    }

    override suspend fun signUp(email: String, password: String): Response {
        return try {
            val response = client.auth.signUpWith(Email){
                this.email = email
                this.password = password
            }
            Response(response.toString())
        } catch (e: Exception) {
            Log.d("error sign up", e.message.toString())
            Response("", e.message.toString())
        }
    }

    override suspend fun addUser(user: User): Response {
        val currentUser = client.auth.currentUserOrNull()
        return if (currentUser != null) {
            return try {
                val response = client.from("users").insert(user.copy(id = currentUser.id))
                Response(response.toString())
            } catch (e: Exception) {
                Log.d("error add user", e.message.toString())
                Log.d("user", user.copy(id = currentUser.id).toString())
                Response("", e.message.toString())
            }
        } else {
            Log.d("error add user", "Пользователь не авторизован")
            Response("", "Пользователь не авторизован")
        }
    }

}