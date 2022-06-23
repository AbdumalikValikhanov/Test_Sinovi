package com.example.testsinovi.UI;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testsinovi.R;
import com.example.testsinovi.databinding.FragmentTestBinding;
import com.example.testsinovi.model.Question;
import com.example.testsinovi.room.AppDataBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class TestFragment extends Fragment {
    AppDataBase dataBase;
    int startQuestionIndex=1;
    int stopQuestionIndex=30;
    ArrayList<Question> questionsList;
    int queue_number=0;
    FragmentTestBinding binding;
    public TestFragment( int startQuestionIndex,int stopQuestionIndex) {
        super(R.layout.fragment_test);
        this.startQuestionIndex=startQuestionIndex;
        this.stopQuestionIndex=stopQuestionIndex;
    }

    public TestFragment() {
        super(R.layout.fragment_test);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding=FragmentTestBinding.bind(view);
        readData();
        binding.answer1.setOnClickListener(view1 -> {
            checkAnswer(binding.answer1);
        });
        binding.answer2.setOnClickListener(view1 -> {
            checkAnswer(binding.answer2);
        });
        binding.answer3.setOnClickListener(view1 -> {
            checkAnswer(binding.answer3);
        });
        binding.answer4.setOnClickListener(view1 -> {
            checkAnswer(binding.answer4);
        });
        binding.nextQuestion.setOnClickListener(view1 -> {
            nextQuestion();
        });
        binding.prevQuestion.setOnClickListener(view1 -> prevQuestion());
    }
    private void readData() {
        startQuestionIndex=getArguments().getInt("startQuestionIndex");
        stopQuestionIndex=getArguments().getInt("stopQuestionIndex");
        dataBase= AppDataBase.getDataBase(getContext());
        dataBase.questionDao().getAllRX(startQuestionIndex,stopQuestionIndex).subscribe(new SingleObserver<List<Question>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Question> questions) {
                questionsList= (ArrayList<Question>) questions;
                bindQuestion(questionsList.get(queue_number));
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getContext(),"Savollar topilmadi",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void nextQuestion() {
        if (queue_number+1< questionsList.size()){
            queue_number++;
            resetView();
            bindQuestion(questionsList.get(queue_number));
        }
    }
    private void prevQuestion() {
        if (queue_number-1>=0){
            queue_number--;
            resetView();
            bindQuestion(questionsList.get(queue_number));
        }
    }

    private void checkAnswer(RadioButton radioButton) {

        if (questionsList.get(queue_number).getAnswerA()==radioButton.getText()){
            radioButton.setTextColor(Color.GREEN);
            playSound(true);
        }
        else {
            radioButton.setTextColor(Color.RED);
            playSound(false);
        }
    }
    public void resetView(){
        binding.answer1.setChecked(false);
        binding.answer2.setChecked(false);
        binding.answer3.setChecked(false);
        binding.answer4.setChecked(false);
        binding.answer1.setTextColor(Color.BLACK);
        binding.answer2.setTextColor(Color.BLACK);;
        binding.answer3.setTextColor(Color.BLACK);;
        binding.answer4.setTextColor(Color.BLACK);;
    }
    public void bindQuestion(Question question){
        binding.noticeText.setText(question.getId()+"");
        binding.questionText.setText(question.getQuestion());
        ArrayList<String> answers=question.getAnswers();
        binding.answer1.setText(answers.get(0));
        binding.answer2.setText(answers.get(1));
        binding.answer3.setText(answers.get(2));
        binding.answer4.setText(answers.get(3));
    }
    public void playSound(boolean state){
        MediaPlayer mediaPlayer=new MediaPlayer();
        if (state){
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mediaPlayer.setDataSource(getActivity().getResources().getAssets().openFd("correct_sound.mp3"));
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mediaPlayer.setDataSource(getActivity().getResources().getAssets().openFd("wrong_sound.mp3"));
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
