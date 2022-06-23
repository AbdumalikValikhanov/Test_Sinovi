package com.example.testsinovi.room;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.testsinovi.model.Question;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface QuestionDao {
//    @Query("Select Question.Id,Question.Question,Question.Answer_A,Question.Answer_B,Question.Answer_C,Question.Answer_D from Question order by Id")
//    public List<Question> getAll();
    @Query("Select * from Question order by Id")
    public Single<List<Question> > getAllRX();
    @Query("Select * from Question order by Id")
    public List<Question> getAll();
    @Query("Select * from Question Where Question.Question like  '%' || :targetWord || '%' or Question.Answer_A like  '%' || :targetWord || '%'")
    public List<Question> searchQuestion(String targetWord);
    @Query("Select * from Question where id>=:startIndex and id<=:stopQuestionIndex")
    public Single<List<Question> > getAllRX(int startIndex,int stopQuestionIndex);
}
