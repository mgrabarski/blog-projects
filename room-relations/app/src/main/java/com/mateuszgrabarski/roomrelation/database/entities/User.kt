package com.mateuszgrabarski.roomrelation.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mateuszgrabarski.roomrelation.database.types.DatabaseDate
import com.mateuszgrabarski.roomrelation.database.types.Id

@Entity
data class User(
    @PrimaryKey(autoGenerate = false)
    val id: Id,
    @Embedded
    val loginData: LoginData,
    @Embedded
    val basicInfo: BasicInfo,
    @Embedded
    val contactInfo: ContactInfo,
    val createDate: DatabaseDate
)

data class LoginData(
    val loginUserName: String,
    val password: String
)

data class ContactInfo(
    val email: String,
    val phone: String
)

data class BasicInfo(
    val firstName: String,
    val lastName: String
)

