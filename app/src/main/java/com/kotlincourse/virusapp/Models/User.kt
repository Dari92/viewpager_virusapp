package com.kotlincourse.virusapp.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //with This anotation were saying that this will be an entity for room, User will be like a table for room
data class User (

    @ColumnInfo(name = "first_name") var name: String?, //changing the name of the column with @ColumnInfo(name = " ")
    @ColumnInfo(name = "last_name") var lastName: String,
    @PrimaryKey(autoGenerate = true) val idUser: Int = 0)