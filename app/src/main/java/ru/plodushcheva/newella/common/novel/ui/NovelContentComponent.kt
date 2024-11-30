package ru.plodushcheva.newella.common.novel.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.plodushcheva.newella.common.novel.domain.entity.Novel

@Composable
fun NovelContentComponent(
	novel: Novel
) {
	Column {
		Text(text = "It's novel!")
	}
}