package ru.plodushcheva.newella.center.reading.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import ru.plodushcheva.newella.R
import ru.plodushcheva.newella.center.reading.domain.entity.Page

class ReadingViewModel(
    private val readingRouter: ReadingRouter
) : ViewModel() {

    private val _state = MutableStateFlow<ReadingState>(ReadingState.Initial)
    val state: StateFlow<ReadingState> = _state

    private var currentPageIndex = 0

    private val pages = listOf(
        Page(
            title = "Страница 1",
            speaker = "Говорящий 1",
            text = "Введение в новеллу. Это первая страница, где описывается основной сюжет.",
            imageResId = R.drawable.sample_image_reading_1
        ),
        Page(
            title = "Страница 2",
            speaker = "Говорящий 2",
            text = "Развитие сюжета. Здесь появляются новые персонажи и события.",
            imageResId = R.drawable.sample_image_reading_1
        ),
        Page(
            title = "Страница 3",
            speaker = null,
            text = "Кульминация. Напряжение достигает своего пика.",
            imageResId = R.drawable.sample_image_reading_1
        ),
        Page(
            title = "Страница 4",
            speaker = "Говорящий 3",
            text = "Финал. История подходит к логическому завершению.",
            imageResId = R.drawable.sample_image_reading_1
        )
    )



    init {
        load()
    }

    private fun load() {
        _state.update {
            ReadingState.Content(
                currentPage = pages[currentPageIndex]
            )
        }
    }

    fun onPreviousPage() {
        if (currentPageIndex > 0) {
            currentPageIndex--
            load()
        }
    }

    fun onNextPage() {
        if (currentPageIndex < pages.size - 1) {
            currentPageIndex++
            load()
        }
    }
}