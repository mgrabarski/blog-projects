package com.mateuszgrabarski.roomrelation.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.mateuszgrabarski.roomrelation.database.entities.IdentificationCard

@Dao
interface IdentificationCardDao {

    @Insert
    suspend fun insert(card: IdentificationCard)
}