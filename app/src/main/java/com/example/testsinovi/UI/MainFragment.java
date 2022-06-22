package com.example.testsinovi.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.testsinovi.R;
import com.example.testsinovi.databinding.FragmentMainBinding;
import com.example.testsinovi.room.AppDataBase;

public class MainFragment extends Fragment {
    FragmentMainBinding binding;
    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding=FragmentMainBinding.bind(view);
        NavHostFragment navHostFragment= (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.second_fragment_container);
        NavController navController=navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomAppbar,navController);
        AppDataBase database =AppDataBase.getDataBase(getContext());
//        Toast.makeText(getContext(),database.questionDao().getAll().size()+"",Toast.LENGTH_LONG).show();
    }
}
