package com.imran.roommvvm.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.imran.roommvvm.daos.StudentDao
import com.imran.roommvvm.models.Student

@Database(entities = [Student::class], version = 1)
abstract class SchoolDatabase : RoomDatabase(){

    abstract fun studentDao() : StudentDao


}