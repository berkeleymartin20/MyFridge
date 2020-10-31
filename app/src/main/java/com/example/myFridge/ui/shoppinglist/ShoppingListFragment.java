package com.example.myFridge.ui.shoppinglist;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myFridge.R;
import com.google.android.material.snackbar.ContentViewCallback;

import java.util.ArrayList;

public class ShoppingListFragment extends Fragment {

    private RecyclerView recyclerview;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shoppinglist, container, false);
        recyclerview = view.findViewById(R.id.recyclerview);
        ListAdapter listAdapter = new ListAdapter();
        ShoppingList.add("water3",3);
        ShoppingList.add("steak5",5);
        ShoppingList.add("bread10",10);
        ShoppingList.add("pasta3",5);
        ShoppingList.replaceQuantity("pasta3",3);
        recyclerview.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((getActivity()));
        recyclerview.setLayoutManager(layoutManager);

        return view;
    }


}