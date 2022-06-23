package com.example.testsinovi.UI.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testsinovi.R;
import com.example.testsinovi.databinding.QuestionItemLayoutBinding;
import com.example.testsinovi.model.Question;

import java.util.ArrayList;

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.QuestionHolder> {
    QuestionSelect questionSelect;
    public SearchRecyclerViewAdapter(ArrayList<Question> questions, QuestionSelect questionSelect) {
        this.questions = questions;
        this.questionSelect=questionSelect;
    }

    ArrayList<Question> questions;

    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View qestionView = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item_layout, parent, false);

        return new QuestionHolder(qestionView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {
        holder.bindView(questions.get(position));
    }

    @Override
    public int getItemCount() {
        return questions.size();
//        return 5;
    }

    class QuestionHolder extends RecyclerView.ViewHolder {
        QuestionItemLayoutBinding binding;

        public QuestionHolder(@NonNull View itemView) {
            super(itemView);
            binding = QuestionItemLayoutBinding.bind(itemView);
        }

        public void bindView(Question question) {
            if (question != null) {
                binding.questionNumberText.setText(question.getId() + "");
                binding.questionText.setText(question.getQuestion());
                itemView.setOnClickListener(v->{questionSelect.showQuestion(question);});
            }

        }
    }
}
