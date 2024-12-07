package ru.plodushcheva.newella.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.plodushcheva.newella.home.presentation.HomeState
import ru.plodushcheva.newella.home.presentation.HomeViewModel
import ru.plodushcheva.newella.library.ui.NovelSection

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
){
    val state by homeViewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Заголовок
        Text(
            text = "Home",
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 16.dp)
        )

        when (state) {
            is HomeState.Content -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    (state as HomeState.Content).sections.forEach { section ->
                        item {
                            NovelSection(
                                title = section.title,
                                items = section.novels,
                                onItemClicked = homeViewModel::openNovel
                            )
                        }
                    }
                }
            }
            else -> {
                Text(text = "Loading or Error")
            }
        }
    }
}