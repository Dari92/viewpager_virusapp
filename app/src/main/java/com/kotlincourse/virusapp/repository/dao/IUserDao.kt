package com.kotlincourse.virusapp.repository.dao

import androidx.room.*
import com.kotlincourse.virusapp.Models.User

@Dao //Data access object, Design Patern that help us to order, structure the acces to the operations with DB

interface IUserDao {

    //1- here Im gonna create functions for delete, update, etc etc

    @Query("DELETE FROM User")// 3- for delete all we need an specific query
    fun deleteAll()

    @Query("SELECT * FROM User") //4
    fun getAll(): List<User> //Obtenemos lista de los usuarios

    @Query("SELECT * FROM User WHERE first_name LIKE :first AND last_name LIKE :last") //Query to get the user who has the same name and lastname that the parameters
    fun finByName(first: String?, last: String?) : List<User> //This function has 2 parameters and will return also a list of User



    @Update
    fun update(user: User)

    @Insert
    fun insert(vararg user: User)//I added vararg it will allow to insert unlimeted number of users

    @Delete
    fun delete (user: User)



    //2 - add the anotations for each function

}





