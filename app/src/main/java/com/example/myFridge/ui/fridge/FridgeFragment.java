package com.example.myFridge.ui.fridge;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myFridge.R;
import com.example.myFridge.ui.shoppinglist.AddItemFragment;
import com.example.myFridge.ui.shoppinglist.ShoppingListFragment;

public class FridgeFragment extends Fragment {

    private ImageButton addItemButton;
    private boolean drag;
    private RecyclerView fridgeRecyclerView;
    private float dx;
    private float dy;

    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fridge, container, false);
        FridgeListAdapter fridgeListAdapter = new FridgeListAdapter();
        fridgeRecyclerView = view.findViewById(R.id.main_fridge_recyclerView);
        fridgeRecyclerView.setAdapter(fridgeListAdapter);
        drag = false;
        addItemButton = view.findViewById(R.id.add_item_fridge_button);
        addItemButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        if(!drag) {
                            AddFridgeItemFragment addFridgeItemFragment = new AddFridgeItemFragment();
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.fridge_fragment, addFridgeItemFragment);
                            transaction.commit();
                        }
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
                AddFridgeItemFragment addFridgeItemFragment = new AddFridgeItemFragment();
                FridgeFragment shoppingListFragment = new FridgeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fridge_fragment, addFridgeItemFragment);
                transaction.commit();
            }
        });
*/



        return view;
    }


}