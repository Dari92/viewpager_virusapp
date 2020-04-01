package com.kotlincourse.virusapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.google.gson.Gson
import com.kotlincourse.virusapp.Models.User
import com.kotlincourse.virusapp.repository.dao.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class RoomActivity : AppCompatActivity() {

    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        //Working with coroutines
        runBlocking {databaseCalls() }

    }

    private suspend fun databaseCalls() {
        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, DATABASE_NAME).build()//this is for getting an instance for the database (context, class with db, name of
        // data base, this is declared in Cons.kt

        //Dispatcher IO is a kotlin web services an also bc im working with DB
        withContext(Dispatchers.IO){

            try {
            db.userDao().deleteAll()


           //This line will show us in LogCat the result, using log.i
            Log.i(DATABASE_LOG_TAG, "Deleted all the data from table")

            //Insert some users
            db.userDao().insert(User("Dariana", "Vielma"), User("Lia", "Vielma"), User("Meredith", "Vielma"), User("test", "test2"))

            Log.i(DATABASE_LOG_TAG, "Inserted data")

            //get all the data just to know all the users that are in the database
            var userlist = db.userDao().getAll()
            Log.i(DATABASE_LOG_TAG, "Retreived data: "+ gson.toJson(userlist))//other log to check

            //set some values in order to get the users
            val firstUser = userlist[0]
            val secondUser = userlist[1]
            val thirdUser = userlist[2]
            val fourUser = userlist[3]

            //If I want update
            firstUser.name = "Dari"
            db.userDao().update(firstUser)
            Log.i(DATABASE_LOG_TAG, "User updated: "+ gson.toJson(firstUser))

            userlist = db.userDao().finByName("Me%", "Vie%")
            Log.i(DATABASE_LOG_TAG, "Reserched: "+ gson.toJson(userlist))

            db.userDao().delete(fourUser)
            Log.i(DATABASE_LOG_TAG, "User deleted: "+ gson.toJson(fourUser))

            //get all again
            userlist = db.userDao().getAll()
            Log.i(DATABASE_LOG_TAG, "Again Retreived data: "+ gson.toJson(userlist))//other log to check

            }catch (e: Exception){
                e.printStackTrace()
            }


        }
    }
}
