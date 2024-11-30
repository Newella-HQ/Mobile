package ru.plodushcheva.newella.common.novel.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.plodushcheva.newella.R
import ru.plodushcheva.newella.common.novel.presentation.NovelState
import ru.plodushcheva.newella.common.novel.presentation.NovelViewModel
import ru.plodushcheva.newella.common.ui.ErrorComponent
import ru.plodushcheva.newella.common.ui.LoadingComponent

@Composable
fun NovelScreen(
	viewModel: NovelViewModel,
) {
	val novelState by viewModel.state.collectAsState()

	LaunchedEffect(Unit) {
		viewModel.loadNovel()
	}
	
	Column(modifier = Modifier.fillMaxSize()) {

		Row(
			verticalAlignment = Alignment.CenterVertically,
		) {
			Icon(
				modifier = Modifier
					.padding(start = 8.dp)
					.clickable { viewModel.goBack() },
				imageVector = Icons.AutoMirrored.Default.ArrowBack,
				contentDescription = "",
			)
			Text(
				modifier = Modifier
					.fillMaxWidth()
					.padding(vertical = 12.dp, horizontal = 8.dp),
				text = stringResource(id = R.string.novel_title),
				style = MaterialTheme.typography.titleLarge,
			)
		}

		when (val state = novelState) {
			is NovelState.Initial,
			is NovelState.Loading -> LoadingComponent()

			is NovelState.Failure -> ErrorComponent(
				message = state.message ?: stringResource(id = R.string.error_unknown_error),
				onRetry = {
					viewModel.loadNovel()
				}
			)

			is NovelState.Content -> NovelContentComponent(
				novel = state.novel,
			)
		}
	}
}