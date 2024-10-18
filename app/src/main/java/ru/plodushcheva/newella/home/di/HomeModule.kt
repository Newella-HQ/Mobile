package ru.plodushcheva.newella.home.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plodushcheva.newella.home.presentation.HomeViewModel


val homeModule = module {

    viewModelOf(::HomeViewModel)
}