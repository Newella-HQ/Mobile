package ru.plodushcheva.newella.profile.domain.usecase

import ru.plodushcheva.newella.profile.domain.repository.ProfileModeRepository

class GetModeUseCase(private val profileModeRepository: ProfileModeRepository) {

    suspend operator fun invoke(): Boolean =
        profileModeRepository.getMode()
}