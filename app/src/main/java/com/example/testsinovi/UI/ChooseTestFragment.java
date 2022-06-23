package com.example.testsinovi.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.testsinovi.R;
import com.example.testsinovi.databinding.FragmentChooseTestBinding;
import com.example.testsinovi.model.Question;
import com.example.testsinovi.room.AppDataBase;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class ChooseTestFragment extends Fragment {
    FragmentChooseTestBinding binding;
    AppDataBase dataBase;
    int range=30;
    ArrayList<Question> questionsList;
    public ChooseTestFragment() {

        super(R.layout.fragment_choose_test);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding=FragmentChooseTestBinding.bind(view);
        readData();
        setButtonsText(binding.linerContainer,splitTest(questionsList));
    }

    private void readData() {
        dataBase=AppDataBase.getDataBase(getContext());
        dataBase.questionDao().getAllRX().subscribe(new SingleObserver<List<Question>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Question> questions) {
                questionsList= (ArrayList<Question>) questions;
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getContext(),"Savollar topilmadi",Toast.LENGTH_LONG).show();
            }
        });
    }

    public  ArrayList<Integer>  splitTest(ArrayList<Question> currentQuestions){
        ArrayList<Integer> test_list=new ArrayList<>();
        int size=currentQuestions.size();

        for (int i = 0; currentQuestions.size()-i>0 ; i+=range) {
            test_list.add(i);

        }



        for (int text:test_list
             ) {
            Log.i("AAA",text+"");
        }
        return test_list;

    }
    public void setButtonsText(LinearLayout linearLayout,ArrayList<Integer> test_list){

        for (Integer i:test_list)  {
            MaterialButton button= new MaterialButton(getContext());
            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            button.setText((i+1)+"-"+(i+range<questionsList.size()?i+range:questionsList.size()));
            button.setOnClickListener(view -> openTest(i));
            button.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            linearLayout.addView(button);


        }
    }
    public void openTest(Integer i){
//        ArrayList<Question> selectedQuestion=(ArrayList<Question>) questionsList.subList(i,i+range<questionsList.size()?i+range:questionsList.size()-1);
//            getActivity().getSupportFragmentManager().beginTransaction()
//                    .addToBackStack("")
//                    .add(R.id.main_nav_container,new TestFragment(i+1,i+range<questionsList.size()?i+range:questionsList.size())).commit();

//        NavController controller= Navigation.findNavController(getActivity(),R.id.main_nav_container);

        NavController controller=Navigation.findNavController(getView());

        Bundle bundle=new Bundle();
        bundle.putInt("startQuestionIndex",i+1);
        bundle.putInt("stopQuestionIndex",i+range<questionsList.size()?i+range:questionsList.size());

        controller.navigate(R.id.action_chooseTest_to_testFragment2,bundle);
    }
}
