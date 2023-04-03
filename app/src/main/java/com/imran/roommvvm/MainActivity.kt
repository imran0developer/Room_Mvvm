package com.imran.roommvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import com.imran.roommvvm.database.SchoolDatabase
import com.imran.roommvvm.models.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    lateinit var schoolDatabase: SchoolDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        schoolDatabase = Room.databaseBuilder(applicationContext,
        SchoolDatabase::class.java,
        "school_db").build()

      GlobalScope.launch {
            schoolDatabase.studentDao().insertStudent(Student(0,"imran","ceo"))
//            schoolDatabase.studentDao().insertStudent(Student(1,"faisal","cfo"))
//            schoolDatabase.studentDao().insertStudent(Student(2,"ahmed","cmo"))
        }


    }

    fun getStudents(view: View) {
        schoolDatabase.studentDao().getAllStudents().observe(this){
            Log.d("TAG2", it.toString())
        }
    }
}

