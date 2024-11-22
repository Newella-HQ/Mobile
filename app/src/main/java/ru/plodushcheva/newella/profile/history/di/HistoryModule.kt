package ru.plodushcheva.newella.profile.history.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plodushcheva.newella.profile.history.presentation.HistoryViewModel

val historyModule = module {
	viewModelOf(::HistoryViewModel)
}