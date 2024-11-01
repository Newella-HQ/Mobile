package ru.plodushcheva.newella.profile.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.plodushcheva.newella.profile.data.repository.ProfileProfileModeRepositoryImpl
import ru.plodushcheva.newella.profile.domain.repository.ProfileModeRepository
import ru.plodushcheva.newella.profile.domain.usecase.GetModeUseCase
import ru.plodushcheva.newella.profile.presentation.ProfileViewModel

val profileModule = module {

    singleOf(::ProfileProfileModeRepositoryImpl) bind ProfileModeRepository::class


    factoryOf(::GetModeUseCase)

    viewModel{
        ProfileViewModel(get(), get())
    }
}