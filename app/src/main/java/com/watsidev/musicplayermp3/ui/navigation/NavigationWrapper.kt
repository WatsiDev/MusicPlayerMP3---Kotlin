package com.watsidev.musicplayermp3.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.watsidev.musicplayermp3.ui.screens.configuration.ConfigurationScreen
import com.watsidev.musicplayermp3.ui.screens.home.HomeScreen
import com.watsidev.musicplayermp3.ui.screens.musicplayer.MusicPlayerScreen

@Composable
fun MusicPlayerApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        composable<Home> {
            HomeScreen(
                onMusicPlayerNavigate = { navController.navigate(MusicPlayer) },
                onSettingsNavigate = { navController.navigate(Configuration) }
            )
        }
        composable<MusicPlayer> {
             MusicPlayerScreen()
        }
        composable<Configuration> {
             ConfigurationScreen(
                    onBackNavigate = { navController.popBackStack() }
             )
        }
    }
}