package ru.plodushcheva.newella.search.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.plodushcheva.newella.library.ui.NovelSection
import ru.plodushcheva.newella.search.presentation.SearchViewModel
import ru.plodushcheva.newella.search.presentation.SearchState

@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel
){
    val state by searchViewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Search!!!")

        SearchWithFiltersComponent()

        when (state) {
            is SearchState.Content -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    (state as SearchState.Content).sections.forEach { section ->
                        item {
                            NovelSection(
                                title = section.title,
                                items = section.novels,
                                onItemClicked = searchViewModel::openNovel
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