package com.example.myFridge.ui.fridge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myFridge.R;
import com.example.myFridge.ui.alert.AlertViewModel;

public class FridgeFragment extends Fragment {

    FridgeViewModel fridgeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fridgeViewModel =
                ViewModelProviders.of(this).get(FridgeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fridge, container, false);
        final TextView textView = root.findViewById(R.id.text_alert);
        fridgeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}