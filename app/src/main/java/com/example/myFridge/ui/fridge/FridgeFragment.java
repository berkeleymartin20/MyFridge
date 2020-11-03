package com.example.myFridge.ui.fridge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myFridge.R;

import java.util.ArrayList;
import java.util.List;

public class FridgeFragment extends Fragment {

    private RecyclerView fridgeRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fridge, container, false);
        FridgeListAdapter fridgeListAdapter = new FridgeListAdapter(FridgeList.getSectionList());
        fridgeRecyclerView = view.findViewById(R.id.main_fridge_recyclerView);
        fridgeRecyclerView.setAdapter(fridgeListAdapter);


        return view;
    }
}