package ru.plodushcheva.newella.profile.main.domain.usecase

import ru.plodushcheva.newella.profile.main.domain.repository.ProfileModeRepository


class SaveModeUseCase(private val profileModeRepository: ProfileModeRepository) {

    suspend operator fun invoke(mode: Boolean) =
        profileModeRepository.saveMode(mode)
}