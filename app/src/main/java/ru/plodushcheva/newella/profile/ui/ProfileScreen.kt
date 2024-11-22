package ru.plodushcheva.newella.profile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.plodushcheva.newella.profile.presentation.ProfileState
import ru.plodushcheva.newella.profile.presentation.ProfileViewModel

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel
) {
    val profileState by profileViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        profileViewModel.loadMode()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (val state = profileState) {
            is ProfileState.Initial -> {
                Text(text = "Welcome! Loading your profile...")
            }
            is ProfileState.Loading -> {
                Text(text = "Loading...")
            }
            is ProfileState.Failure -> {
                Text(text = "Error: ${state.message ?: "Unknown error"}")
            }
            is ProfileState.Content -> {
                ProfileContentComponent(
                    onAuthClicked = profileViewModel::openAuth,
                    onAboutClicked = profileViewModel::openAbout,
                    onRatingsClicked = profileViewModel::openRatings,
                    onHistoryClicked = profileViewModel::openHistory,
                    onSettingsClicked = profileViewModel::openSettings
                )

                val currentModeText = if (state.profile.mode) "Режим создания" else "Режим чтения"
                val switchButtonText = if (state.profile.mode) "Переключить на чтение" else "Переключить на создание"

                Text(text = "Текущий режим: $currentModeText")

                Button(onClick = { profileViewModel.toggleMode() }) {
                    Text(text = switchButtonText)
                }
            }
        }
    }
}
