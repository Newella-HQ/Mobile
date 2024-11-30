package ru.plodushcheva.newella.common.novel.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.plodushcheva.newella.common.novel.presentation.NovelViewModel

val novelModule = module {
	viewModel {(novelId: Int) ->
		NovelViewModel(novelId, get())
	}
}