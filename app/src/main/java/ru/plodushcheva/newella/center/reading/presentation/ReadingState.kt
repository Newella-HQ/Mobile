package ru.plodushcheva.newella.center.reading.presentation

import ru.plodushcheva.newella.center.reading.domain.entity.Page

sealed interface ReadingState {

    data object Initial : ReadingState
    data object Loading : ReadingState
    data class Failure(val message: String?) : ReadingState
    data class Content(val currentPage: Page) : ReadingState

}