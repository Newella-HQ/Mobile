package ru.plodushcheva.newella.center.reading.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.plodushcheva.newella.center.reading.presentation.ReadingViewModel

@Composable
fun ReadingScreen(
    readingViewModel: ReadingViewModel
) {
    Column {
        Text(text = "Reading")
    }
}