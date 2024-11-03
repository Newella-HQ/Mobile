package ru.plodushcheva.newella.profile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.plodushcheva.newella.R

@Composable
fun ProfileContentComponent(
    onAuthClicked: () -> Unit,
) {
    Column {
        Button(onClick = { onAuthClicked() }) {
            Text(text = stringResource(R.string.to_auth))
        }
    }
}