package ru.plodushcheva.newella.db.mode

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ModeDB::class], version = 1)
abstract class ModeDatabase : RoomDatabase() {
    abstract fun modeDao(): ModeDao
}