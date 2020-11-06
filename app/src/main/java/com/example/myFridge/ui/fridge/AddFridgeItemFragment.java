package com.example.myFridge.ui.fridge;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myFridge.R;
import com.example.myFridge.ui.shoppinglist.AddItemFragment;
import com.example.myFridge.ui.shoppinglist.ShoppingList;
import com.example.myFridge.ui.shoppinglist.ShoppingListFragment;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class AddFridgeItemFragment extends Fragment {

    private ImageButton backButton;
    private Button submitButton;
    private EditText nameEdit;
    private EditText numberEdit;
    private EditText dateEdit;
    private AutoCompleteTextView categoryEdit;
    private ArrayList<String> categoryOptions;

    private boolean nameEntered;
    private boolean numberEntered;
    private boolean dateEntered;
    private boolean categoryEntered;

    private String itemNameFromSL;
    private int itemQtyFromSL;
    private boolean fromSL;

    public AddFridgeItemFragment(){
        fromSL = false;
    }
    public AddFridgeItemFragment(String name, int qty) {
        itemNameFromSL = name;
        itemQtyFromSL = qty;
        fromSL = true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fridge_additem,container,false);
        backButton = view.findViewById(R.id.add_item_fridge_cancel_button);
        submitButton = view.findViewById(R.id.add_item_fridge_submit_button);
        nameEdit = view.findViewById(R.id.fridge_item_name_input);
        numberEdit = view.findViewById(R.id.fridge_item_qty_input);
        dateEdit = view.findViewById(R.id.fridge_item_exp_date_input);
        categoryEdit = view.findViewById(R.id.fridge_item_category_input);

        nameEntered = false;
        numberEntered = false;
        if(fromSL) {
            nameEdit.setText(itemNameFromSL);
            numberEdit.setText(String.valueOf(itemQtyFromSL));
            nameEntered = true;
            numberEntered = true;
        }
        submitButton.setEnabled(false);
        categoryOptions = new ArrayList<String>(Arrays.asList("Freezer","Meat","Produce","Seafood"));
        dateEntered = false;
        categoryEntered = false;

        //nameEdit
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
                    if(nameEntered && numberEntered && dateEntered && categoryEntered) {
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

        //numberEdit
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
                    if(nameEntered && numberEntered && dateEntered && categoryEntered) {
                        submitButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //dateEdit
        Calendar myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateInput = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                myCalendar.set(Calendar.YEAR, i);
                myCalendar.set(Calendar.MONTH, i1);
                myCalendar.set(Calendar.DAY_OF_MONTH, i2);
                dateEdit.setText(""+myCalendar.get(Calendar.YEAR) +"." + (myCalendar.get(Calendar.MONTH) + 1) + "." + myCalendar.get(Calendar.DAY_OF_MONTH));
            }
        };
        dateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getContext(),android.R.style.Theme_Holo_Dialog, dateInput,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }

        });
        dateEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(s.toString().trim().length() == 0) {
                    submitButton.setEnabled(false);
                } else {
                    dateEntered = true;
                    if(nameEntered && numberEntered && dateEntered && categoryEntered) {
                        submitButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //categoryEdit
        categoryEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu categoryPop = new PopupMenu(getContext(),categoryEdit);
                categoryPop.getMenuInflater().inflate(R.menu.category_options_popup,categoryPop.getMenu());
                categoryPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        categoryEdit.setText(menuItem.getTitle());
                        categoryEntered = true;
                        if(nameEntered && numberEntered && dateEntered && categoryEntered) {
                            submitButton.setEnabled(true);
                        }
                        return true;
                    }
                });
                categoryPop.show();
            }
        });

        //backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FridgeFragment fridgeFragment = new FridgeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(((ViewGroup)getView().getParent()).getId(),fridgeFragment);
                transaction.addToBackStack(null).detach(fridgeFragment).attach(fridgeFragment).commitAllowingStateLoss();
            }
        });

        //submitButton
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = nameEdit.getText().toString();
                String category = categoryEdit.getText().toString();
                int year = myCalendar.get(Calendar.YEAR);
                int month = myCalendar.get(Calendar.MONTH)+1;
                int day = myCalendar.get(Calendar.DAY_OF_MONTH);
                if (FridgeList.contains(itemName)) {
                    Handler mhandler = new Handler();
                    mhandler.postDelayed(new AddFridgeItemFragment.DisplayToast(getContext(), "WARNING: This item name already exists"), 200);
                } else if(!categoryOptions.contains(categoryEdit.getText().toString())){
                    Handler mhandler = new Handler();
                    mhandler.postDelayed(new AddFridgeItemFragment.DisplayToast(getContext(), "WARNING: Invalid Category!"), 200);
                }else {
                    if(fromSL) {
                        ShoppingList.items.remove(itemNameFromSL);
                    }
                    int quantity = Integer.parseInt(numberEdit.getText().toString());
                    FridgeList.add(category,itemName,quantity,LocalDate.of(year,month,day));
                    FridgeFragment fridgeFragment = new FridgeFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(((ViewGroup)getView().getParent()).getId(),fridgeFragment);
                    transaction.addToBackStack(null).detach(fridgeFragment).attach(fridgeFragment).commitAllowingStateLoss();
                }

            }
        });

        return view;
    }

    public class DisplayToast implements Runnable {
        private final Context mContext;
        private final String mText;

        public DisplayToast(Context mContext, String text) {
            this.mContext = mContext;
            mText = text;
        }
        @Override
        public void run() {
            Toast toastWarning = Toast.makeText(mContext, mText, Toast.LENGTH_SHORT);
            toastWarning.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
            toastWarning.show();
        }
    }
}
