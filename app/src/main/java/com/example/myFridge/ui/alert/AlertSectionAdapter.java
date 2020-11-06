package com.example.myFridge.ui.alert;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myFridge.R;
import com.example.myFridge.ui.fridge.EditFridgeItemFragment;
import com.example.myFridge.ui.fridge.FridgeList;
import com.example.myFridge.ui.fridge.FridgeSectionAdapter;
import com.example.myFridge.ui.fridge.fridgeCategories.Node;
import com.example.myFridge.ui.fridge.fridgeCategories.ProduceList;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class AlertSectionAdapter extends RecyclerView.Adapter<AlertSectionAdapter.ViewHolder> implements View.OnClickListener {

    private int sectionIndex;
    private Object[] nameAndDatesSortedArr;

    private TextView itemName;
    private TextView itemExpDate;

    public AlertSectionAdapter(int sectionIndex) {
        this.sectionIndex = sectionIndex;
        nameAndDatesSortedArr = FridgeList.getItemDateALArray(sectionIndex);
    }

    @Override
    public void onClick(View view) {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.alert_item,parent,false);
        return new AlertSectionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        Node thisItem = (Node)nameAndDatesSortedArr[position];
        String name = thisItem.getName();
        LocalDate date = thisItem.getDate();
        LocalDate today = LocalDate.now();
        long daysBetween = ChronoUnit.DAYS.between(today,date);
        itemName.setText(name);
        itemExpDate.setText("Days Left: " + daysBetween);
        if(daysBetween < 3) {
            itemExpDate.setBackgroundColor(Color.parseColor("#FB6962"));
        } else if (daysBetween < 7) {
            itemExpDate.setBackgroundColor(Color.parseColor("#FCFC99"));
        } else if (daysBetween < 14) {
            itemExpDate.setBackgroundColor(Color.parseColor("#79DE79"));
        } else {
            itemExpDate.setBackgroundColor(Color.parseColor("#0CC078"));
        }
    }

    @Override
    public int getItemCount() {
        return nameAndDatesSortedArr.length;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.alert_item_name);
            itemExpDate = itemView.findViewById(R.id.alert_item_exp_date);
        }


    }
}
