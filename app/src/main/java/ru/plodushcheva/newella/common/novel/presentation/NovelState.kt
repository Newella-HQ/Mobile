package ru.plodushcheva.newella.common.novel.presentation

import ru.plodushcheva.newella.common.novel.domain.entity.Novel

interface NovelState {

	data object Initial : NovelState
	data object Loading : NovelState
	data class Failure(val message: String?) : NovelState
	data class Content(val novel: Novel) : NovelState
}