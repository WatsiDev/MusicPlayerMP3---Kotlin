package com.watsidev.musicplayermp3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.watsidev.musicplayermp3.ui.navigation.MusicPlayerApp
import com.watsidev.musicplayermp3.ui.theme.MusicPlayerMP3Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        splashScreen.setKeepOnScreenCondition {
            runBlocking {
                delay(1500)
            }
            false
        }
        setContent {
            MusicPlayerMP3Theme {
                MusicPlayerApp()
            }
        }
    }
}