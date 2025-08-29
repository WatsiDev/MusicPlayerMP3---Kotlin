package com.watsidev.musicplayermp3.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    onMusicPlayerNavigate: () -> Unit,
    onSettingsNavigate: () -> Unit
) {
    Scaffold(
        topBar = { HomeTopBar( navigateToConfiguration = { onSettingsNavigate() }) },
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Text(
                "Home Screen",
            )
            Button(
                onClick = { onMusicPlayerNavigate() }
            ) {
                Text("Go to Music Player")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    navigateToConfiguration: () -> Unit
) {
    TopAppBar(
        title = { Text("Music Player") },
        actions = {
            Icon(
                Icons.Default.Settings,
                contentDescription = "Go to settings",
                modifier = Modifier
                    .clickable{ navigateToConfiguration() }
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}