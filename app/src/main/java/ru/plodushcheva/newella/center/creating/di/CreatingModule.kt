package ru.plodushcheva.newella.center.creating.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plodushcheva.newella.center.creating.presentation.CreatingViewModel


val creatingModule = module {

    viewModelOf(::CreatingViewModel)
}