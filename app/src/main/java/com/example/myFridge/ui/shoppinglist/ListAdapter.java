package com.example.myFridge.ui.shoppinglist;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myFridge.R;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter {

    //static ShoppingList list;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //add text to each card for each position
        ((ListViewHolder)holder).bindView(position);
        ((ListViewHolder)holder).mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean check = ShoppingList.getChecked(holder.getAdapterPosition());
                if (!check) {
                    ShoppingList.itemsChecked.set(holder.getAdapterPosition(),true);
                } else {
                    ShoppingList.itemsChecked.set(holder.getAdapterPosition(),false);
                }
            }
        });
        ((ListViewHolder) holder).mDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String item = ShoppingList.items.get(holder.getAdapterPosition());
                ShoppingList.itemsChecked.remove(holder.getAdapterPosition());
                ShoppingList.removeItem(item);
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(),getItemCount());
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public int getItemCount() {
        return ShoppingList.items.size();
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mItemName;
        private TextView mQuantity;
        private ImageButton mDelete;
        private CheckBox mCheckBox;

        public ListViewHolder(View itemView) {
            super(itemView);
            mCheckBox = itemView.findViewById(R.id.checkitem);
            mItemName = itemView.findViewById(R.id.itemname);
            mQuantity = itemView.findViewById(R.id.item_quantity);
            mDelete = itemView.findViewById(R.id.item_delete);
            itemView.setOnClickListener(this);
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public void bindView (int position) {
            String[] name_Qty = ShoppingList.getNameAndQtyInOrder(position);
            Boolean bool = ShoppingList.getChecked(position);
            mCheckBox.setChecked(bool);
            mItemName.setText(name_Qty[0]);
            mQuantity.setText("Qty: " + name_Qty[1]);
        }

        public void onClick(View view) {

        }
    }
}
