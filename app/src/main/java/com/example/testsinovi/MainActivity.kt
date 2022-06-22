package com.example.testsinovi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testsinovi.room.AppDataBase

import kotlin.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {

//            var dataBase=AppDataBase.getDatabase(baseContext)
        }
        catch (e:Exception){
            Toast.makeText(baseContext,e.message,Toast.LENGTH_LONG).show()
        }

    }
}