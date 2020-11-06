package com.example.myFridge.ui.shoppinglist;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myFridge.R;
import com.example.myFridge.ui.fridge.AddFridgeItemFragment;
import com.example.myFridge.ui.fridge.FridgeList;

public class PopUpMoveItem extends Fragment {

    public void showPopUpWindow(View view, String name, int count) {
        LayoutInflater inflater = (LayoutInflater)view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_move_item_to_fridge,null);
        TextView statement = popUpView.findViewById(R.id.popup_description_moveToFridge);
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        String question = "Do you want to move \"" + name + "\" to Fridge?";
        statement.setText(question.toString());
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popUpView,width,height,focusable);

        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);

        Button cancelButton = popUpView.findViewById(R.id.cancel_move_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        Button confirmButton = popUpView.findViewById(R.id.confirm_move_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                AddFridgeItemFragment addFridgeItemFragment = new AddFridgeItemFragment(name,count);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.shoppinglist_fragment,addFridgeItemFragment).commit();
                popupWindow.dismiss();
            }
        });


    }

}
