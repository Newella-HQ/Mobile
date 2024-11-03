package ru.plodushcheva.newella.profile.auth.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.plodushcheva.newella.profile.auth.presentation.AuthViewModel

@Composable
fun AuthScreen(
    authViewModel: AuthViewModel
){
    Column {
        Text(text = "Auth")
    }
}