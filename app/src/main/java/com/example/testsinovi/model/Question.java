package com.example.testsinovi.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    @PrimaryKey(autoGenerate = true)
    int uid;
    @ColumnInfo(name="Question")
    String question;
    @ColumnInfo(name="Answer_A")
    String answerA;
    @ColumnInfo(name="Answer_B")
    String answerB;
    @ColumnInfo(name="Answer_C")
    String answerC;
    @ColumnInfo(name="Answer_D")
    String answerD;
    ArrayList<String> answers=new ArrayList<>();

    public Question(int uid, String question, String answerA, String answerB, String answerC, String answerD) {
        this.uid = uid;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;

    }
}
