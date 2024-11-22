package ru.plodushcheva.newella.profile.ratings.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.plodushcheva.newella.profile.ratings.presentation.RatingsViewModel

@Composable
fun RatingsScreen(
	ratingsViewModel: RatingsViewModel
) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(text = "Ratings")
	}
}