package ru.plodushcheva.newella.db.mode

import androidx.room.*

@Dao
interface ModeDao {
    @Query("SELECT * FROM mode WHERE id = 1")
    suspend fun getMode(): ModeDB?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMode(mode: ModeDB)
}
