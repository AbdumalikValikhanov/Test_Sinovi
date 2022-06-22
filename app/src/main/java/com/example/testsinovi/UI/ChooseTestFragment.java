package com.example.testsinovi.UI;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.testsinovi.R;
import com.example.testsinovi.databinding.FragmentChooseTestBinding;
import com.example.testsinovi.room.AppDataBase;

public class ChooseTestFragment extends Fragment {
    FragmentChooseTestBinding binding;
    public ChooseTestFragment() {

        super(R.layout.fragment_choose_test);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding=FragmentChooseTestBinding.bind(view);
        AppDataBase database =AppDataBase.getDataBase(getContext());
        binding.textView.setText(database.questionDao().getAll().size()+"");

    }
}
