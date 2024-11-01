package ru.plodushcheva.newella.profile.data.repository

import ru.plodushcheva.newella.db.mode.ModeDB
import ru.plodushcheva.newella.db.mode.ModeDao
import ru.plodushcheva.newella.profile.domain.repository.ProfileModeRepository


class ProfileModeRepositoryImpl(
    private val dao: ModeDao
) : ProfileModeRepository {

    override suspend fun getMode(): Boolean {
        return dao.getMode()?.isCreating ?: true
    }

    override suspend fun saveMode(mode: Boolean) {
        dao.insertMode(ModeDB(1, mode)) //TODO converter?
    }

}