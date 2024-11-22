package ru.plodushcheva.newella.profile.ratings.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plodushcheva.newella.profile.ratings.presentation.RatingsViewModel

val ratingsModule = module {
	viewModelOf(::RatingsViewModel)
}