package ru.plodushcheva.newella.main.domain.repository

interface MainModeRepository {

    suspend fun getMode(): Boolean

}