package com.example.testsinovi.UI;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testsinovi.R;
import com.example.testsinovi.databinding.QuestionLayoutBinding;
import com.example.testsinovi.model.Question;

public class AnswerFragment extends Fragment {
    Question question;
QuestionLayoutBinding binding;
    public AnswerFragment(Question question) {
        super(R.layout.question_layout);
        this.question = question;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding=QuestionLayoutBinding.bind(view);

        binding.questionText.setText(question.getQuestion());
        binding.answerText.setText(question.getAnswerA());
    }

}
