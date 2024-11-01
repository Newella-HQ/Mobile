package ru.plodushcheva.newella.main.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.plodushcheva.newella.main.data.repository.MainModeRepositoryImpl
import ru.plodushcheva.newella.main.domain.repository.MainModeRepository
import ru.plodushcheva.newella.main.domain.usecase.GetModeUseCase
import ru.plodushcheva.newella.main.presentation.MainViewModel

val mainModule = module {
    singleOf(::MainModeRepositoryImpl) bind MainModeRepository::class


    factoryOf(::GetModeUseCase)

    viewModel{
        MainViewModel(get(), get())
    }

}