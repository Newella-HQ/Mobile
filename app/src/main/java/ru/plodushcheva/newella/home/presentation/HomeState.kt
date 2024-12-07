package ru.plodushcheva.newella.home.presentation

import ru.plodushcheva.newella.library.domain.entity.NovelSection

sealed interface HomeState {

	data object Initial : HomeState
	data object Loading : HomeState
	data class Failure(val message: String?) : HomeState
	data class Content(val sections: List<NovelSection> = emptyList()) : HomeState

}