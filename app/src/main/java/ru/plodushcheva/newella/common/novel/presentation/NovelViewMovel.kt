package ru.plodushcheva.newella.common.novel.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.plodushcheva.newella.common.novel.domain.entity.Novel
import kotlin.coroutines.cancellation.CancellationException

class NovelViewModel(
	private val novelId: Int,
	//private val getNovelUseCase: GetNovelUseCase,
	private val router: NovelRouter,
) : ViewModel() {

	private val _state = MutableStateFlow<NovelState>(NovelState.Initial)
	val state: StateFlow<NovelState> = _state

	fun loadNovel() {
		if (_state.value is NovelState.Content || _state.value is NovelState.Loading) {
			return
		}

		val novel = Novel(novelId, "Cool Novel", "Actually, not cool")
		_state.value = NovelState.Content(novel)

		/*viewModelScope.launch {
			_state.value = NovelState.Loading

			try {
				val novel = getNovelUseCase(novelId)
				_state.value = NovelState.Content(novel)
			} catch (ce: CancellationException) {
				throw ce
			} catch (ex: Exception) {
				_state.value = NovelState.Failure(ex.message)
			}
		}

		 */
	}

	fun goBack() {
		router.goBack()
	}
}