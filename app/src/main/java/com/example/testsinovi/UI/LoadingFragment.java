package com.example.testsinovi.UI;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.testsinovi.R;
import com.example.testsinovi.databinding.FragmentLoadingBinding;

public class LoadingFragment extends Fragment {
    FragmentLoadingBinding binding;
    public LoadingFragment() {
        super(R.layout.fragment_loading);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding= FragmentLoadingBinding.bind(view);
        Glide.with(getContext()).load(R.drawable.loading).into(binding.loadingImg);
    }
}
