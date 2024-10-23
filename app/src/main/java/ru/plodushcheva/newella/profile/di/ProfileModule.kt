package ru.plodushcheva.newella.profile.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plodushcheva.newella.profile.presentation.ProfileViewModel

val profileModule = module {
    viewModelOf(::ProfileViewModel)
}