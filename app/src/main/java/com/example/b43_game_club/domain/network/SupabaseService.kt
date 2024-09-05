package com.example.b43_game_club.domain.network

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

interface SupabaseService {

    companion object {
        fun create(): SupabaseServiceImpl {
            return SupabaseServiceImpl(
                client = createSupabaseClient(
                    supabaseUrl = "https://qzzdrdlnmzjjfzbaotjq.supabase.co",
                    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InF6emRyZGxubXpqamZ6YmFvdGpxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MjU1NTczNjMsImV4cCI6MjA0MTEzMzM2M30.2YxGz6RH0LIstPF6r5c1636yZVipah56k1QX7qNUYm8")
                {
                    install(Auth)
                    install(Postgrest)
                    install(Storage)
                }
            )
        }
    }

}