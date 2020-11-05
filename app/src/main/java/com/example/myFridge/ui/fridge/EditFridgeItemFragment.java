package com.example.myFridge.ui.fridge;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myFridge.R;

public class EditFridgeItemFragment extends Fragment {

    private String currentitemname;
    private int currentqty;

    public EditFridgeItemFragment(String name, int qty) {
        currentitemname = name;
        currentqty = qty;
    }

    private ImageButton backbutton;
    private Button editItemButton;
    private Button deleteItemButton;
    private EditText newItemQty;
    private TextView currentItemName;
    private TextView currentItemQty;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println(currentitemname.toString());
        View view = inflater.inflate(R.layout.fridge_edit_item, container, false);
        backbutton = view.findViewById(R.id.edit_item_cancel_button);
        editItemButton = view.findViewById(R.id.fridge_window_edit_button);
        deleteItemButton = view.findViewById(R.id.fridge_window_delete_button);
        newItemQty = view.findViewById(R.id.fridge_edit_item_new_qty);
        currentItemName = view.findViewById(R.id.fridge_selected_item_name);
        currentItemQty = view.findViewById(R.id.fridge_selected_item_qty);

        currentItemName.setText(currentitemname);
        currentItemQty.setText(String.valueOf(currentqty));
        editItemButton.setEnabled(false);
        newItemQty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().trim().length() == 0) {
                    editItemButton.setEnabled(false);
                } else {
                    editItemButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        editItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newQty = Integer.parseInt(newItemQty.getText().toString());
                FridgeList.changeItemQty(currentitemname,newQty);
                FridgeFragment fridgeFragment = new FridgeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(((ViewGroup)getView().getParent()).getId(),fridgeFragment);
                transaction.addToBackStack(null).detach(fridgeFragment).attach(fridgeFragment).commitAllowingStateLoss();
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FridgeFragment fridgeFragment = new FridgeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(((ViewGroup)getView().getParent()).getId(),fridgeFragment);
                transaction.addToBackStack(null).detach(fridgeFragment).attach(fridgeFragment).commitAllowingStateLoss();
            }
        });

        deleteItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FridgeList.removeItem(currentitemname);
                FridgeFragment fridgeFragment = new FridgeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(((ViewGroup)getView().getParent()).getId(),fridgeFragment);
                transaction.addToBackStack(null).detach(fridgeFragment).attach(fridgeFragment).commitAllowingStateLoss();
            }
        });


        return view;
    }
}
