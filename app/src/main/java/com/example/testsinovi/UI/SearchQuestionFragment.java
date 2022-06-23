package com.example.testsinovi.UI;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.testsinovi.R;
import com.example.testsinovi.UI.Adapters.QuestionSelect;
import com.example.testsinovi.UI.Adapters.SearchRecyclerViewAdapter;
import com.example.testsinovi.databinding.FragmentSearchQuestionBinding;
import com.example.testsinovi.model.Question;
import com.example.testsinovi.room.AppDataBase;

import java.util.ArrayList;

public class SearchQuestionFragment extends Fragment {
    FragmentSearchQuestionBinding binding;
    QuestionSelect questionSelect;
    ArrayList<Question> resultSearchQuestion = new ArrayList<>();

    public SearchQuestionFragment() {
        super(R.layout.fragment_search_question);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchQuestionBinding.bind(view);
        super.onViewCreated(view, savedInstanceState);
        questionSelect=new QuestionSelect() {
            @Override
            public void showQuestion(Question question) {
                InputMethodManager manager= (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(view.getWindowToken(), 0);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack("")
                        .add(R.id.main_nav_container,new AnswerFragment(question))
                        .commit();

            }
        };
        SearchRecyclerViewAdapter adapter = new SearchRecyclerViewAdapter(resultSearchQuestion, questionSelect);
        binding.searchResultListView.setAdapter(adapter);
        binding.searchResultListView.getAdapter().notifyDataSetChanged();
        binding.searchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.i("AAA", binding.searchEdit.getText().toString());
                AppDataBase dataBase = AppDataBase.getDataBase(getContext());
                resultSearchQuestion.clear();
                resultSearchQuestion.addAll((ArrayList) dataBase.questionDao().searchQuestion(binding.searchEdit.getText().toString().trim()));
                binding.searchResultListView.setAdapter(new SearchRecyclerViewAdapter(resultSearchQuestion, questionSelect));
                //Toast.makeText(getContext(),resultSearchQuestion.size()+"",Toast.LENGTH_LONG).show();
                binding.searchResultListView.getAdapter().notifyDataSetChanged();
                binding.noticeText.setText("Topilgan natijalar:"+resultSearchQuestion.size());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}

