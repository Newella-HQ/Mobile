package ru.plodushcheva.newella.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.plodushcheva.newella.home.presentation.HomeViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
){
    Column {
        Text(text = "Newella!!!")
    }
}