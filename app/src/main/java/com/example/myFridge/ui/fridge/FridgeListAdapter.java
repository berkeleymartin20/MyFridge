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

public class FridgeListAdapter extends RecyclerView.Adapter<FridgeListAdapter.ViewHolderList> {

    //List<Section> sectionList;
    Section section;
    public FridgeListAdapter(){
        //this.sectionList = sectionList;
        //setHasStableIds(true);
    }

    @NonNull
    @Override
    public ViewHolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.section_fragment_fridge,parent,false);
        return new ViewHolderList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderList holder, int position) {
        section = FridgeList.getSectionList().get(position);
        String sectionName = section.getSectionName();
        holder.sectionName.setText(sectionName);
        FridgeSectionAdapter fridgeSectionAdapter = new FridgeSectionAdapter(FridgeList.getSectionList().get(position).getSectionItems(),position);
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
    public int getItemCount() { return FridgeList.sectionList.size();
    }




    class ViewHolderList extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView sectionName;
        private RecyclerView sectionRecyclerView;

        public ViewHolderList(View itemView) {
            super(itemView);
            sectionName = itemView.findViewById(R.id.section_fridgeHeader);
            sectionRecyclerView = itemView.findViewById(R.id.sectionContent_RecyclerView);
            sectionRecyclerView.setAnimation(null);

        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void bindView (int position) {
        }

        public void onClick(View view) {

        }
    }
}
