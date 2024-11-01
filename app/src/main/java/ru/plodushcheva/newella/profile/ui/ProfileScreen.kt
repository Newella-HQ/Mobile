package ru.plodushcheva.newella.profile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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

    Column {
        Text(text = "Profile!")

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
                Text(text = "Content: ${state.profile.mode}")
            }
        }
    }
}
