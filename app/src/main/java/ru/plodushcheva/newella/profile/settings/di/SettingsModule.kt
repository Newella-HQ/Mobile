package ru.plodushcheva.newella.profile.settings.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plodushcheva.newella.profile.settings.presentation.SettingsViewModel

val settingsModule = module {
	viewModelOf(::SettingsViewModel)
}
