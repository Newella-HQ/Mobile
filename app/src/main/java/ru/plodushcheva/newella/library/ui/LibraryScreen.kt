package ru.plodushcheva.newella.library.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.plodushcheva.newella.library.presentation.LibraryViewModel

@Composable
fun LibraryScreen(
    libraryViewModel: LibraryViewModel
){
    Column {
        Text(text = "Library!!!")
    }
}