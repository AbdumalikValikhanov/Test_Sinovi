package com.example.testsinovi;

import androidx.lifecycle.ViewModel;

import com.example.testsinovi.model.Question;

import java.util.ArrayList;

public class QuestionViewModel extends ViewModel {
    ArrayList<Question> questions;
    public void fillQuestion(  ArrayList<Question> questions){
        this.questions=questions;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
