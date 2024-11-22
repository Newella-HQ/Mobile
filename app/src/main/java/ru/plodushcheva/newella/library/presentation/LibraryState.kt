package ru.plodushcheva.newella.library.presentation

import ru.plodushcheva.newella.library.domain.entity.NovelSection

sealed interface LibraryState {

    data object Initial : LibraryState
    data object Loading : LibraryState
    data class Failure(val message: String?) : LibraryState
    data class Content(val sections: List<NovelSection> = emptyList()) : LibraryState

}