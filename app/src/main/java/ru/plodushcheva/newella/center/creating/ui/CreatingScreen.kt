package ru.plodushcheva.newella.center.creating.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.plodushcheva.newella.center.creating.presentation.CreatingViewModel

@Composable
fun CreatingScreen(
    creatingViewModel: CreatingViewModel
){
    Column {
        Text(text = "Crating!!!")
    }
}