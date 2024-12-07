package ru.plodushcheva.newella.home.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import ru.plodushcheva.newella.R
import ru.plodushcheva.newella.library.domain.entity.NovelItem
import ru.plodushcheva.newella.library.domain.entity.NovelSection

class HomeViewModel(
    private val router: HomeRouter,
) : ViewModel() {
    private val _state = MutableStateFlow<HomeState>(HomeState.Initial)
    val state: StateFlow<HomeState> = _state

    init {
        loadSections()
    }

    private fun loadSections() {
        _state.update {
            HomeState.Content(
                sections = listOf(
                    NovelSection(
                        title = "Продолжить читать",
                        novels = listOf(
                            NovelItem(1, R.drawable.empty_novel_h),
                            NovelItem(2, R.drawable.empty_novel_h),
                            NovelItem(3, R.drawable.empty_novel_h),
                            NovelItem(4, R.drawable.empty_novel_h),
                        )
                    ),
                    NovelSection(
                        title = "Продолжить создавать",
                        novels = listOf(
                            NovelItem(3, R.drawable.empty_novel_h),
                            NovelItem(4, R.drawable.empty_novel_h),
                        )
                    ),
                    NovelSection(
                        title = "Новое",
                        novels = listOf(
                            NovelItem(5, R.drawable.empty_novel_v),
                            NovelItem(6, R.drawable.empty_novel_v),
                        )
                    ),
                    NovelSection(
                        title = "От ваших авторов",
                        novels = listOf(
                            NovelItem(7, R.drawable.empty_novel_v),
                            NovelItem(8, R.drawable.empty_novel_v),
                            NovelItem(9, R.drawable.empty_novel_v),
                            NovelItem(10, R.drawable.empty_novel_v),
                        )
                    ),
                    NovelSection(
                        title = "Популярное",
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