package com.example.testsinovi.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Collections;

@Entity
public class Question {
    @PrimaryKey(autoGenerate = true)
    int Id;
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

//    ArrayList<String> answers=new ArrayList<String>();

    public Question(int uid, String question, String answerA, String answerB, String answerC, String answerD) {
        this.Id = uid;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
//        answers.add(answerA);
//        answers.add(answerB);
//        answers.add(answerC);
//        answers.add(answerD);
//        Collections.shuffle(answers);
    }

    public Question() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

//    public ArrayList<String> getAnswers() {
//        return answers;
//    }


}
