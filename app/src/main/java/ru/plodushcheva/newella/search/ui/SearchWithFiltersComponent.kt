package ru.plodushcheva.newella.search.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun SearchWithFiltersComponent(

) {
	var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(vertical = 8.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		BasicTextField(
			value = searchQuery,
			onValueChange = { newValue ->
				searchQuery = newValue
			},
			modifier = Modifier
				.weight(1f)
				.padding(8.dp),
			decorationBox = { innerTextField ->
				Box(
					modifier = Modifier
						.background(MaterialTheme.colorScheme.surfaceContainer)
						.fillMaxWidth()
						.padding(8.dp)
						.height(48.dp),
					contentAlignment = Alignment.CenterStart
				) {
					if (searchQuery.text.isEmpty()) {
						Text(text = "Search for novels...", color = MaterialTheme.colorScheme.outline)
					}
					innerTextField()
				}
			}
		)

		Icon(
			imageVector = Icons.Default.Search,
			contentDescription = "Search",
			modifier = Modifier
				.size(48.dp)
				.padding(8.dp)
				.clickable {
				}
		)

		Icon(
			imageVector = Icons.Default.Menu,
			contentDescription = "Filter",
			modifier = Modifier
				.size(48.dp)
				.padding(8.dp)
				.clickable {
				}
		)
	}
}