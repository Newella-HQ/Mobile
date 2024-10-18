package ru.plodushcheva.newella.main.di

import ru.plodushcheva.newella.main.presentation.MainViewModel

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val mainModule = module {
    viewModelOf(::MainViewModel)

}