package ru.plodushcheva.newella.profile.auth.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plodushcheva.newella.profile.auth.presentation.AuthViewModel

val authModule = module {

    viewModelOf(::AuthViewModel)
}