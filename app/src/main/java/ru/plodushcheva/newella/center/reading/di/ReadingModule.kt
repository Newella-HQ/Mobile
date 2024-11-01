package ru.plodushcheva.newella.center.reading.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.plodushcheva.newella.center.reading.presentation.ReadingViewModel

val readingModule = module {
    viewModelOf(::ReadingViewModel)
}