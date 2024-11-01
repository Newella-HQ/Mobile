package ru.plodushcheva.newella.main.domain.usecase

import ru.plodushcheva.newella.main.domain.repository.MainModeRepository


class GetModeUseCase(private val mainModeRepository: MainModeRepository) {

    suspend operator fun invoke(): Boolean =
        mainModeRepository.getMode()
}