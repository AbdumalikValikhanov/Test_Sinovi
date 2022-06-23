package com.example.testsinovi.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.versionedparcelable.VersionedParcelize;

import java.util.ArrayList;
import java.util.Collections;

@Entity
public class Question implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    Integer Id;

    @ColumnInfo(name="Question")
    @NonNull
    String question;
    @ColumnInfo(name="Answer_A")@NonNull
    String answerA;
    @ColumnInfo(name="Answer_B")@NonNull
    String answerB;
    @ColumnInfo(name="Answer_C")@NonNull
    String answerC;
    @ColumnInfo(name="Answer_D")@NonNull
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

    protected Question(Parcel in) {
        if (in.readByte() == 0) {
            Id = null;
        } else {
            Id = in.readInt();
        }
        question = in.readString();
        answerA = in.readString();
        answerB = in.readString();
        answerC = in.readString();
        answerD = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.Id);
        parcel.writeString(this.question);
        parcel.writeString(this.answerA);
        parcel.writeString(this.answerB);
        parcel.writeString(this.answerC);
        parcel.writeString(this.answerD);

    }

    public ArrayList<String> getAnswers() {
        ArrayList<String> ansewers=new ArrayList<String>();
        ansewers.add(answerA);
        ansewers.add(answerB);
        ansewers.add(answerC);
        ansewers.add(answerD);
        Collections.shuffle(ansewers);
        return ansewers;
    }


}
