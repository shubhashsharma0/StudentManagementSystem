package com.example.studentmanagementsystem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AllFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        RecyclerView recy_view = view.findViewById(R.id.rec_view);
        recy_view.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ArrayList<ArrayList<String>> whole_table = (new Manage(getContext())).getTable();
        recy_view.setAdapter(new RecyclerAdapter(view.getContext(), whole_table));

        return view;
    }
}