package com.example.myFridge.ui.fridge;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myFridge.R;

import java.util.ArrayList;
import java.util.List;

public class FridgeListAdapter extends RecyclerView.Adapter<FridgeListAdapter.ViewHolder> {

    List<Section> sectionList;
    public FridgeListAdapter(List<Section> sectionList){
        this.sectionList = sectionList;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());


        View view = layoutInflater.inflate(R.layout.section_fragment_fridge,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Section section = sectionList.get(position);
        String sectionName = section.getSectionName();
        List<String> items = section.getSectionItems();

        holder.sectionName.setText(sectionName);

        FridgeSectionAdapter fridgeSectionAdapter = new FridgeSectionAdapter(items);
        holder.sectionRecyclerView.setAdapter(fridgeSectionAdapter);

    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
   @Override
    public int getItemCount() {
        return sectionList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView sectionName;
        private RecyclerView sectionRecyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            sectionName = itemView.findViewById(R.id.section_fridgeHeader);
            sectionRecyclerView = itemView.findViewById(R.id.sectionContent_RecyclerView);

        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void bindView (int position) {
        }

        public void onClick(View view) {

        }
    }
}
