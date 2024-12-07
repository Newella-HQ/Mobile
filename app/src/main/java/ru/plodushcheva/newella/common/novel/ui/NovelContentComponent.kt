package ru.plodushcheva.newella.common.novel.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.plodushcheva.newella.common.novel.domain.entity.Novel

@Composable
fun NovelContentComponent(
	novel: Novel
) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp)
	) {
		Image(
			painter = painterResource(id = novel.imageResId),
			contentDescription = "Novel Image",
			modifier = Modifier
				.fillMaxWidth()
				.padding(bottom = 16.dp)
		)

		Text(
			text = novel.name,
			style = MaterialTheme.typography.headlineMedium,
			modifier = Modifier.padding(bottom = 8.dp)
		)

		Text(
			text = novel.description,
			style = MaterialTheme.typography.bodyLarge,
			modifier = Modifier.padding(bottom = 16.dp)
		)
	}
}
