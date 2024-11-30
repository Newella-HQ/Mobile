package ru.plodushcheva.newella.search.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import ru.plodushcheva.newella.R
import ru.plodushcheva.newella.library.domain.entity.NovelItem
import ru.plodushcheva.newella.library.domain.entity.NovelSection

class SearchViewModel(
    private val router: SearchRouter,
) : ViewModel() {

    private val _state = MutableStateFlow<SearchState>(SearchState.Initial)
    val state: StateFlow<SearchState> = _state

    init {
        loadSections()
    }

    private fun loadSections() {
        _state.update {
            SearchState.Content(
                sections = listOf(
                    NovelSection(
                        title = "Новое",
                        novels = listOf(
                            NovelItem(1, R.drawable.empty_novel_h),
                            NovelItem(2, R.drawable.empty_novel_h),
                            NovelItem(3, R.drawable.empty_novel_h),
                            NovelItem(4, R.drawable.empty_novel_h),
                        )
                    ),
                    NovelSection(
                        title = "Популярное",
                        novels = listOf(
                            NovelItem(3, R.drawable.empty_novel_h),
                            NovelItem(4, R.drawable.empty_novel_h),
                        )
                    ),
                    NovelSection(
                        title = "Рекомендуемое",
                        novels = listOf(
                            NovelItem(5, R.drawable.empty_novel_v),
                            NovelItem(6, R.drawable.empty_novel_v),
                        )
                    ),
                    NovelSection(
                        title = "Обновления",
                        novels = listOf(
                            NovelItem(7, R.drawable.empty_novel_v),
                            NovelItem(8, R.drawable.empty_novel_v),
                            NovelItem(9, R.drawable.empty_novel_v),
                            NovelItem(10, R.drawable.empty_novel_v),
                        )
                    ),
                    NovelSection(
                        title = "Подборка",
                        novels = listOf(
                            NovelItem(9, R.drawable.empty_novel_v),
                            NovelItem(10, R.drawable.empty_novel_v),
                        )
                    )
                )
            )
        }
    }

    fun openNovel(novelId: Int) {
        router.openNovel(novelId)
    }

}