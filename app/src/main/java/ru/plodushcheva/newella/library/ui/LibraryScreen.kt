package ru.plodushcheva.newella.library.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import ru.plodushcheva.newella.library.presentation.LibraryViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.plodushcheva.newella.library.domain.entity.NovelItem
import ru.plodushcheva.newella.library.presentation.LibraryState

@Composable
fun LibraryScreen(
    libraryViewModel: LibraryViewModel
){
    val state by libraryViewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Заголовок
        Text(
            text = "Newella",
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 16.dp)
        )

        when (state) {
            is LibraryState.Content -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    (state as LibraryState.Content).sections.forEach { section ->
                        item {
                            NovelSection(
                                title = section.title,
                                items = section.novels,
                                onItemClicked = libraryViewModel::openNovel
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

@Composable
fun NovelSection(
    title: String,
    items: List<NovelItem>,
    onItemClicked: (Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items.size) { index ->
                val item = items[index]
                NovelCard(
                    item = item,
                    onClick = { onItemClicked(item.id) }
                )
            }
        }
    }
}

@Composable
fun NovelCard(
    item: NovelItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(width = 120.dp, height = 160.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
