package com.kotlincourse.virusapp.repository.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kotlincourse.virusapp.DATABASE_VERSION
import com.kotlincourse.virusapp.Models.User

//I use the anotation to say that its a DataBase, and Im gonna set the entities tahat ill be using
@Database(entities = [User::class], version = DATABASE_VERSION ) // the entity is User, and I need to add the version of the data base this version is asignated to a variable in Const.kt
abstract class AppDatabase : RoomDatabase() { //convert this class to an abstaract class and it'll be extend from RoomDatabae()
    abstract  fun userDao(): IUserDao //set the name of our Dao, this function will extend from IUserDao

}