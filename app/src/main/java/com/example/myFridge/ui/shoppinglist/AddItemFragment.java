package com.example.myFridge.ui.shoppinglist;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myFridge.R;

public class AddItemFragment extends Fragment {
    private ImageButton backButton;
    private Button submitButton;
    private EditText nameEdit;
    private EditText numberEdit;

    private boolean nameEntered;
    private boolean numberEntered;
    public AddItemFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_additem,container,false);
        backButton = view.findViewById(R.id.add_item_cancel_button);
        submitButton = view.findViewById(R.id.add_item_confirm_button);
        nameEdit = view.findViewById(R.id.itemname_input);
        numberEdit = view.findViewById(R.id.quantity_input);

        submitButton.setEnabled(false);
        nameEntered = false;
        numberEntered = false;


        nameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(s.toString().trim().length() == 0) {
                    submitButton.setEnabled(false);
                } else {
                    nameEntered = true;
                    if(numberEntered == true) {
                        submitButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = editable.toString();
                if(s.toString().trim().length() == 0) {
                    editable.clear();
                }
            }
        });
        numberEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(s.toString().trim().length() == 0) {
                    submitButton.setEnabled(false);
                } else {
                    numberEntered = true;
                    if(nameEntered == true) {
                        submitButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShoppingListFragment shoppingListFragment = new ShoppingListFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.addItem_fragment,shoppingListFragment);
                transaction.hide(AddItemFragment.this);
                transaction.commit();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = nameEdit.getText().toString();
                int quantity = Integer.parseInt(numberEdit.getText().toString());
                ShoppingList.add(itemName,quantity);
                ShoppingListFragment shoppingListFragment = new ShoppingListFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(((ViewGroup)getView().getParent()).getId(),shoppingListFragment);
                transaction.addToBackStack(null).detach(shoppingListFragment).attach(shoppingListFragment).commitAllowingStateLoss();
            }
        });
        return view;
    }


}
