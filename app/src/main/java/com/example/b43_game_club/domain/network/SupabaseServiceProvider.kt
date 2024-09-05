package com.example.b43_game_club.domain.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SupabaseServiceProvider {

    @Provides
    fun provideService(): SupabaseServiceImpl {
        return SupabaseService.create()
    }

}