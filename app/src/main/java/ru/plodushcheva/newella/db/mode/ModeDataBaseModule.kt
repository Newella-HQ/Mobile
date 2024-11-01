package ru.plodushcheva.newella.db.mode

import org.koin.dsl.module
import androidx.room.Room

val modeDataBaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            ModeDatabase::class.java,
            "mode_database"
        ).build()
    }

    single {
        get<ModeDatabase>().modeDao()
    }
}