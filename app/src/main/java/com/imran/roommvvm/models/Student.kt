package com.imran.roommvvm.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val course:String
)
