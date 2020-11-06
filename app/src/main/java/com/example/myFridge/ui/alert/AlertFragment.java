package com.example.myFridge.ui.alert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myFridge.R;

public class AlertFragment extends Fragment {

    private RecyclerView alertRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alert, container, false);
        AlertListAdapter alertListAdapter = new AlertListAdapter();
        alertRecyclerView = view.findViewById(R.id.main_alert_recyclerView);
        alertRecyclerView.setAdapter(alertListAdapter);



        return view;
    }
}