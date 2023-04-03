package com.imran.roommvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.imran.roommvvm.daos.StudentDao
import com.imran.roommvvm.models.Student

@Database(entities = [Student::class], version = 1)
abstract class SchoolDatabase : RoomDatabase(){

    abstract fun studentDao() : StudentDao

    companion object{
        @Volatile
        private var INSTANCE : SchoolDatabase? = null

        fun getDetabase(context: Context) : SchoolDatabase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        SchoolDatabase::class.java,
                        "school_db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }


}