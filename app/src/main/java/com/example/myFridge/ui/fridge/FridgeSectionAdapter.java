package com.example.myFridge.ui.fridge;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myFridge.MainActivity;
import com.example.myFridge.R;
import com.example.myFridge.ui.shoppinglist.ShoppingList;
import com.example.myFridge.ui.shoppinglist.ShoppingListFragment;

import java.util.ArrayList;
import java.util.List;

public class FridgeSectionAdapter extends RecyclerView.Adapter<FridgeSectionAdapter.ViewHolder> implements View.OnClickListener {

    private List<String> items;
    private int sectionIndex;

    private TextView itemname;
    private TextView itemQty;
    private ImageButton editItem;

    public FridgeSectionAdapter(List<String> items, int sectionIndex) {
        this.sectionIndex = sectionIndex;
        this.items = items;
        //setHasStableIds(true);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fridge_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        itemname.setText(items.get(position));
        String temp = ""+FridgeList.getQuantity(items.get(position),sectionIndex);
        itemQty.setText(temp);

        editItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                EditFridgeItemFragment editFridgeItemFragment = new EditFridgeItemFragment(items.get(position),FridgeList.getQuantity(items.get(position)));
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fridge_fragment,editFridgeItemFragment).commit();
            }
        });

    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(View view) {

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemname = itemView.findViewById(R.id.fridge_item_name);
            itemQty = itemView.findViewById(R.id.fridge_item_qty);
            editItem = itemView.findViewById(R.id.fridge_item_edit);
        }


    }
}
