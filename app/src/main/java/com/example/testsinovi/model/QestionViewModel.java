package com.example.testsinovi.model;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class QestionViewModel extends ViewModel {
    ArrayList<Question> questions;
    public void fillQuestion(ArrayList<Question> questions){
        this.questions=questions;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
