package ru.plodushcheva.newella.library.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import ru.plodushcheva.newella.R
import ru.plodushcheva.newella.library.domain.entity.NovelItem
import ru.plodushcheva.newella.library.domain.entity.NovelSection

class LibraryViewModel(
    private val router: LibraryRouter,
) : ViewModel() {

    private val _state = MutableStateFlow<LibraryState>(LibraryState.Initial)
    val state: StateFlow<LibraryState> = _state

    init {
        loadSections()
    }

    private fun loadSections() {
        _state.update {
            LibraryState.Content(
                sections = listOf(
                    NovelSection(
                        title = "Продолжить читать",
                        novels = listOf(
                            NovelItem("1", R.drawable.empty_novel_h),
                            NovelItem("2", R.drawable.empty_novel_h),
                            NovelItem("3", R.drawable.empty_novel_h),
                            NovelItem("4", R.drawable.empty_novel_h),
                            )
                    ),
                    NovelSection(
                        title = "Продолжить создавать",
                        novels = listOf(
                            NovelItem("3", R.drawable.empty_novel_h),
                            NovelItem("4", R.drawable.empty_novel_h),
                        )
                    ),
                    NovelSection(
                        title = "Сохраненное",
                        novels = listOf(
                            NovelItem("5", R.drawable.empty_novel_v),
                            NovelItem("6", R.drawable.empty_novel_v),
                        )
                    ),
                    NovelSection(
                        title = "Созданное",
                        novels = listOf(
                            NovelItem("7", R.drawable.empty_novel_v),
                            NovelItem("8", R.drawable.empty_novel_v),
                            NovelItem("9", R.drawable.empty_novel_v),
                            NovelItem("10", R.drawable.empty_novel_v),
                            )
                    ),
                    NovelSection(
                        title = "Прочитанное",
                        novels = listOf(
                            NovelItem("9", R.drawable.empty_novel_v),
                            NovelItem("10", R.drawable.empty_novel_v),
                        )
                    )
                )
            )
        }
    }

    fun openNovel(novelId: String) {
        //router.openNovel(novelId)
    }

}