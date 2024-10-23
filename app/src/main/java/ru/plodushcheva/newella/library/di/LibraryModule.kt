package ru.plodushcheva.newella.library.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plodushcheva.newella.library.presentation.LibraryViewModel


val libraryModule = module {

    viewModelOf(::LibraryViewModel)
}