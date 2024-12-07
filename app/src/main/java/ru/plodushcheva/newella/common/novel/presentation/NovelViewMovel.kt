package ru.plodushcheva.newella.common.novel.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.plodushcheva.newella.R
import ru.plodushcheva.newella.common.novel.domain.entity.Novel
import kotlin.coroutines.cancellation.CancellationException

class NovelViewModel(
	private val novelId: Int,
	private val router: NovelRouter,
) : ViewModel() {

	private val _state = MutableStateFlow<NovelState>(NovelState.Initial)
	val state: StateFlow<NovelState> = _state

	fun loadNovel() {
		if (_state.value is NovelState.Content || _state.value is NovelState.Loading) {
			return
		}

		val novel = Novel(
			id = novelId,
			name = "Cool Novel",
			description = "Hmmmmmmm...",
			imageResId = R.drawable.sample_image_novel
		)

		_state.value = NovelState.Content(novel)

	}

	fun goBack() {
		router.goBack()
	}
}