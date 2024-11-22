package ru.plodushcheva.newella.profile.main.domain.usecase

import ru.plodushcheva.newella.profile.main.domain.repository.ProfileModeRepository

class GetModeUseCase(private val profileModeRepository: ProfileModeRepository) {

    suspend operator fun invoke(): Boolean =
        profileModeRepository.getMode()
}