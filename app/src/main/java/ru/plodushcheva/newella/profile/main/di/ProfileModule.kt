package ru.plodushcheva.newella.profile.main.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.plodushcheva.newella.profile.main.data.repository.ProfileModeRepositoryImpl
import ru.plodushcheva.newella.profile.main.domain.repository.ProfileModeRepository
import ru.plodushcheva.newella.profile.main.domain.usecase.GetModeUseCase
import ru.plodushcheva.newella.profile.main.domain.usecase.SaveModeUseCase
import ru.plodushcheva.newella.profile.main.presentation.ProfileViewModel

val profileModule = module {

    singleOf(::ProfileModeRepositoryImpl) bind ProfileModeRepository::class

    factoryOf(::GetModeUseCase)
    factoryOf(::SaveModeUseCase)

    /*
    viewModel{
        ProfileViewModel(get(), get(), get())
    }
     */

    viewModelOf(::ProfileViewModel)

}