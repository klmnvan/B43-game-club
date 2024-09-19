package com.example.b43_game_club.domain.network

import android.util.Log
import com.example.b43_game_club.domain.repository.PrefManager
import com.example.b43_game_club.model.screens.Response
import com.example.b43_game_club.model.screens.profile.ProfileState
import com.example.b43_game_club.model.screens.supabase.Game
import com.example.b43_game_club.model.screens.supabase.GamePackage
import com.example.b43_game_club.model.screens.supabase.Genre
import com.example.b43_game_club.model.screens.supabase.GetGamePackagesResponse
import com.example.b43_game_club.model.screens.supabase.GetGamesResponse
import com.example.b43_game_club.model.screens.supabase.GetTypePackageResponse
import com.example.b43_game_club.model.screens.supabase.GetUserProfileDataResponse
import com.example.b43_game_club.model.screens.supabase.Role
import com.example.b43_game_club.model.screens.supabase.TypePackage
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

    override suspend fun getTypePackages(): GetTypePackageResponse {
        return try {
            val response = client.from("type_package").select().decodeList<TypePackage>()
            GetTypePackageResponse(response.toMutableList())
        } catch (e: Exception) {
            Log.d("error getTypePackages", e.message.toString())
            GetTypePackageResponse(mutableListOf(), e.message.toString())
        }
    }

    override suspend fun getGamePackages(): GetGamePackagesResponse {
        return try {
            val response = client.from("game_packages").select().decodeList<GamePackage>()
            GetGamePackagesResponse(response.toMutableList())
        } catch (e: Exception) {
            Log.d("error getGamePackages", e.message.toString())
            GetGamePackagesResponse(mutableListOf(), e.message.toString())
        }
    }

    override suspend fun getUserProfileData(): GetUserProfileDataResponse {
        return try {
            var profile = ProfileState()
            var email = ""
            val currentUser = client.auth.currentUserOrNull()
            if(currentUser != null) {
                email = currentUser.email!!
                val user = client.from("users").select{
                    filter {
                        eq("id", currentUser.id)
                    }
                }.decodeSingleOrNull<User>()
                val roles = client.from("roles").select().decodeList<Role>()
                if(user != null) {
                    var role = ""
                    if(roles.isNotEmpty()) role = roles.first { it.id ==  user.idRole}.name
                    profile = profile.copy(
                        id = currentUser.id,
                        name = user.name,
                        surname = user.surname,
                        patronymic = user.patronymic,
                        email = email,
                        role = role)
                }
                return GetUserProfileDataResponse(profile,"")
            }
            GetUserProfileDataResponse(profile,"Пользователь отсутствует в supabase client")
        } catch (e: Exception) {
            Log.d("error getUserProfileData", e.message.toString())
            GetUserProfileDataResponse(null, e.message.toString())
        }
    }

    override suspend fun getGames(): GetGamesResponse {
        return try {
            val games = client.from("games").select().decodeList<Game>()
            val genres = client.from("genres").select().decodeList<Genre>()
            GetGamesResponse(games.toMutableList(), genres.toMutableList())
        } catch (e: Exception) {
            Log.d("error getGamePackages", e.message.toString())
            GetGamesResponse(mutableListOf(), mutableListOf(), e.message.toString())
        }
    }

    override suspend fun updateProfile(name: String, surname: String, patr: String): Response {
        return try {
            val currentUser = client.auth.currentUserOrNull()
            if(currentUser != null) {
                client.from("users").update(
                    {
                        set("name", name)
                        set("surname", surname)
                        set("patronymic", patr)
                    }
                ) {
                    filter {
                        eq("id", currentUser.id)
                    }
                }
                return Response("", "")
            }
            Response("", "Пользователь отсутствует в supabase client")
        } catch (e: Exception) {
            Log.d("error updateProfile", e.message.toString())
            Response("", e.message.toString())
        }
    }

    fun userIsAuth(): Boolean {
        val user = client.auth.currentUserOrNull()?.id
        return user != null
    }

}