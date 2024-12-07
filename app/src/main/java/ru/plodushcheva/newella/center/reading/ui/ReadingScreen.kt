package ru.plodushcheva.newella.center.reading.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.plodushcheva.newella.center.reading.presentation.ReadingState
import ru.plodushcheva.newella.center.reading.presentation.ReadingViewModel
import ru.plodushcheva.newella.common.ui.ErrorComponent
import ru.plodushcheva.newella.common.ui.LoadingComponent

@Composable
fun ReadingScreen(
    readingViewModel: ReadingViewModel
) {
    val state by readingViewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        when (state) {
            is ReadingState.Content -> {
                val contentState = state as ReadingState.Content
                val page = contentState.currentPage

                Image(
                    painter = painterResource(id = page.imageResId),
                    contentDescription = "Novel Image",
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = page.title,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 100.dp)
                        .background(
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(16.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    Column {
                        page.speaker?.let { speaker ->
                            Text(
                                text = "Говорящий: $speaker",
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                        }
                        Text(
                            text = page.text,
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .align(Alignment.BottomCenter)
                        .background(MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.3f)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { readingViewModel.onPreviousPage() },
                        shape = RoundedCornerShape(50),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "Назад", color = MaterialTheme.colorScheme.onPrimary)
                    }

                    Button(
                        onClick = { readingViewModel.onNextPage() },
                        shape = RoundedCornerShape(50),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "Вперёд", color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            }

            is ReadingState.Initial -> {
                LoadingComponent()
            }

            is ReadingState.Failure -> {
                ErrorComponent(message = "Error") {

                }
            }

            else                    -> {}
        }
    }
}