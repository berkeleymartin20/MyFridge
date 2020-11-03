package com.example.myFridge.ui.shoppinglist;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myFridge.R;
import com.google.android.material.snackbar.ContentViewCallback;

import java.util.ArrayList;

public class ShoppingListFragment extends Fragment {
    private ImageButton addItemButton;
    private float dx;
    private float dy;
    private RecyclerView recyclerview;

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shoppinglist, container, false);
        recyclerview = view.findViewById(R.id.recyclerview);
        ListAdapter listAdapter = new ListAdapter();
        recyclerview.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((getActivity()));
        recyclerview.setLayoutManager(layoutManager);
        addItemButton = view.findViewById(R.id.add_item_button);
        addItemButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = v.getX() - event.getRawX();
                        dy = v.getY() - event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        v.setX(event.getRawX()+dx);
                        v.setY(event.getRawY()+dy);
                        break;
                }
                return false;
            }
        });
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddItemFragment addItemFragment = new AddItemFragment();
                ShoppingListFragment shoppingListFragment = new ShoppingListFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.shoppinglist_fragment,addItemFragment);
                transaction.commit();
            }
        });
        return view;
    }


}