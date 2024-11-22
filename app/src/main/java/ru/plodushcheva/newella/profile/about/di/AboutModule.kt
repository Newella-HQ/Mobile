package ru.plodushcheva.newella.profile.about.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plodushcheva.newella.profile.about.presentation.AboutViewModel

val aboutModule = module {
	viewModelOf(::AboutViewModel)
}