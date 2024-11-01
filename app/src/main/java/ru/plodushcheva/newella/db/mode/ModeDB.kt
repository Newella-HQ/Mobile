package ru.plodushcheva.newella.db.mode

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mode")
data class ModeDB(
    @PrimaryKey val id: Int = 1,
    val isCreating: Boolean = true
)

