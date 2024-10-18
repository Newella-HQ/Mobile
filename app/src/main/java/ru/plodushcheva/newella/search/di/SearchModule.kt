package ru.plodushcheva.newella.search.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plodushcheva.newella.search.presentation.SearchViewModel


val searchModule = module {

    viewModelOf(::SearchViewModel)
}