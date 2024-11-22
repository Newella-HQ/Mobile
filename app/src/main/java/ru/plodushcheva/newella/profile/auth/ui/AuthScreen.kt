package ru.plodushcheva.newella.profile.auth.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import ru.plodushcheva.newella.ui.theme.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import ru.plodushcheva.newella.R
import ru.plodushcheva.newella.profile.auth.presentation.AuthViewModel
import ru.plodushcheva.newella.profile.auth.presentation.ItemText
import ru.plodushcheva.newella.profile.auth.presentation.SegmentedButtonItem
import ru.plodushcheva.newella.profile.auth.presentation.SegmentedButtons

@Composable
fun AuthScreen(
    authViewModel: AuthViewModel
){
    val authMode by authViewModel.authMode.collectAsState()

    var isLoading by remember { mutableStateOf(false) } //TODO


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        SegmentedButtons {
            SegmentedButtonItem(
                selected = authMode == AuthViewModel.AuthMode.LOGIN,
                onClick = {
                    authViewModel.setAuthMode(AuthViewModel.AuthMode.LOGIN)
                          },
                label = { ItemText(text = stringResource(R.string.sign_in)) }
            )
            SegmentedButtonItem(
                selected = authMode == AuthViewModel.AuthMode.REGISTER,
                onClick = {
                    authViewModel.setAuthMode(AuthViewModel.AuthMode.REGISTER)
                },
                label = { ItemText(text = stringResource(R.string.sign_up)) }
            )
        }

        if (authMode == AuthViewModel.AuthMode.LOGIN) {
            SignInInputs()

        } else {
            SignUpInputs()
            SignInWithGoogleButton(
                text = "Sign in with Google",
                loadingText = "Signing in...",
                isLoading = isLoading,
                icon = painterResource(id = R.drawable.ic_google_logo),
                onClick = {
                    isLoading = true
                    //TODO
                }
            )
        }
    }
}

@Composable
fun SignUpInputs() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        value = password,
        onValueChange = { password = it },
        label = { Text(stringResource(R.string.password)) },
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun SignInInputs() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    Column {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text(stringResource(R.string.email)) }
        )
    }

}



@Composable
fun SignInWithGoogleButton(
    text: String,
    loadingText: String = "Signing in...",
    icon: Painter,
    isLoading: Boolean = false,
    shape: Shape = Shapes.medium,
    borderColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    progressIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .clickable(
            enabled = !isLoading,
            onClick = onClick)
            .padding(16.dp),
        shape = shape,
        border = BorderStroke(width = 1.dp, color = borderColor),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = icon,
                contentDescription = "SignInButton",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))

            Text(text = if (isLoading) loadingText else text)
            if (isLoading) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
            }
        }
    }
}