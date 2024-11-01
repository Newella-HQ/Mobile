package ru.plodushcheva.newella.main.data.repository

import ru.plodushcheva.newella.db.mode.ModeDao
import ru.plodushcheva.newella.main.domain.repository.MainModeRepository


class MainModeRepositoryImpl(
    private val dao: ModeDao
) : MainModeRepository {

    override suspend fun getMode(): Boolean {
        return dao.getMode()?.isCreating ?: true
    }

}