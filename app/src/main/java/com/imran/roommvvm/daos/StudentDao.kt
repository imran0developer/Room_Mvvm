package com.imran.roommvvm.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.imran.roommvvm.models.Student

@Dao
interface StudentDao {

    @Insert
    suspend fun insertStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)

    @Query("SELECT * FROM students")//query means we can write any query to use accordingly
    //like we make api files in php
    fun getAllStudents() : LiveData<List<Student>>
}