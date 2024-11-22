package ru.plodushcheva.newella.profile.main.domain.repository

interface ProfileModeRepository {

    suspend fun getMode(): Boolean

    suspend fun saveMode(boolean: Boolean)
}