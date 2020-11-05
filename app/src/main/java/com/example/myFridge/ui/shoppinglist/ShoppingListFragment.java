package com.example.myFridge.ui.shoppinglist;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myFridge.R;

public class ShoppingListFragment extends Fragment {
    private ImageButton addItemButton;
    private RecyclerView recyclerview;
    private float dx;
    private float dy;
    private boolean drag;

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shoppinglist, container, false);
        recyclerview = view.findViewById(R.id.recyclerview);
        ListAdapter listAdapter = new ListAdapter();
        recyclerview.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((getActivity()));
        recyclerview.setLayoutManager(layoutManager);

        drag = false;
        addItemButton = view.findViewById(R.id.add_item_shopping_button);
        addItemButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        if(!drag) {
                            AddItemFragment addItemFragment = new AddItemFragment();
                            ShoppingListFragment shoppingListFragment = new ShoppingListFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.shoppinglist_fragment, addItemFragment);
                            transaction.commit();
                        }
                        /*Toast toast = new Toast(getContext());
                        String test = "" + v.getX() + " " + v.getY() + "VIEW: " + v.getHeight() + " " +v.getWidth();
                        Toast.makeText(getContext(),test,Toast.LENGTH_SHORT).show();*/
                    case MotionEvent.ACTION_DOWN:
                        dx = v.getX() - event.getRawX();
                        dy = v.getY() - event.getRawY();
                        drag = false;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if(event.getRawY()+dy > 1350) {
                            v.setY(1350);
                            v.setX(event.getRawX()+dx);
                        } else if (event.getRawY()+dy < -140) {
                            v.setY(-140);
                            v.setX(event.getRawX()+dx);
                        } else {
                            v.setX(event.getRawX()+dx);
                            v.setY(event.getRawY()+dy);
                        }


                        drag = true;
                        break;
                }
                return false;
            }
        });
        /*addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddItemFragment addItemFragment = new AddItemFragment();
                ShoppingListFragment shoppingListFragment = new ShoppingListFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.shoppinglist_fragment, addItemFragment);
                transaction.commit();
            }
        });*/
        return view;
    }


}