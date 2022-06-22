package com.example.testsinovi.room;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.testsinovi.model.Question;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface QuestionDao {
    @Query("Select *from Question order by Id")
    public List<Question> getAll();

}
