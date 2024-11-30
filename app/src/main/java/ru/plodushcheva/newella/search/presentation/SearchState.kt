package ru.plodushcheva.newella.search.presentation

import ru.plodushcheva.newella.library.domain.entity.NovelSection

sealed interface SearchState {

    data object Initial : SearchState
    data object Loading : SearchState
    data class Failure(val message: String?) : SearchState
    data class Content(val sections: List<NovelSection> = emptyList()) : SearchState

}