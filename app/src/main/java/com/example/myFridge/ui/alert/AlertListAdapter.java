package com.example.myFridge.ui.alert;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myFridge.R;
import com.example.myFridge.ui.fridge.FridgeList;
import com.example.myFridge.ui.fridge.FridgeListAdapter;
import com.example.myFridge.ui.fridge.FridgeSectionAdapter;
import com.example.myFridge.ui.fridge.Section;

public class AlertListAdapter extends RecyclerView.Adapter<AlertListAdapter.ViewHolderList> {

    Section section;

    @NonNull
    @Override
    public ViewHolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.section_fragment_alert,parent,false);
        return new AlertListAdapter.ViewHolderList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderList holder, int position) {
        section = FridgeList.getSectionList().get(position);
        String sectionName = section.getSectionName();
        holder.sectionName.setText(sectionName);
        AlertSectionAdapter alertSectionAdapter = new AlertSectionAdapter(position);
        holder.sectionRecyclerView.setAdapter(alertSectionAdapter);
    }

    @Override
    public int getItemCount() { return FridgeList.getSectionList().size(); }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolderList extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView sectionName;
        private RecyclerView sectionRecyclerView;

        public ViewHolderList(View itemView) {
            super(itemView);
            sectionName = itemView.findViewById(R.id.section_alertHeader);
            sectionRecyclerView = itemView.findViewById(R.id.sectionContent_alert_RecyclerView);
            sectionRecyclerView.setAnimation(null);

        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void bindView (int position) {
        }

        public void onClick(View view) {

        }
    }
}
