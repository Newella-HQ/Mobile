package ru.plodushcheva.newella.search.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.plodushcheva.newella.search.presentation.SearchViewModel

@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel
){
    Column {
        Text(text = "Search!!!")
    }
}