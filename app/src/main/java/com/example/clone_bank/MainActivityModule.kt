package com.example.clone_bank

import androidx.navigation.ui.AppBarConfiguration
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object MainActivityModule {
    @Provides
    fun provideAppBarConfiguration(): AppBarConfiguration =
        AppBarConfiguration(setOf(R.id.navigation_home, R.id.navigation_dashboard,
            R.id.navigation_notifications, R.id.navigation_more))
}