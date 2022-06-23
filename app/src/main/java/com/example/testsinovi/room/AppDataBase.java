package com.example.testsinovi.room;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.testsinovi.model.Question;

@Database(entities = {Question.class},version = 1)
public abstract class AppDataBase extends RoomDatabase{
    public static AppDataBase dataBase;
    public abstract QuestionDao questionDao();

    public AppDataBase() {
    }

    public static AppDataBase getDataBase(Context context) {
        if (dataBase==null){
            try {

                dataBase=Room.databaseBuilder(context,AppDataBase.class,"Test.db")
                        .createFromAsset("Test.db").allowMainThreadQueries()
                        .build();
                Toast.makeText(context,"Databse working",Toast.LENGTH_LONG).show();
            }
            catch (Exception e){
                Toast.makeText(context,"Databse error",Toast.LENGTH_LONG).show();
            }
        }
        return dataBase;
    }
}
