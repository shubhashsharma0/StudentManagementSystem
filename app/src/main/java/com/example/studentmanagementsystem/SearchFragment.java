package com.example.studentmanagementsystem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SearchFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        ((Button) v.findViewById(R.id.search)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roll = ((EditText)v.findViewById(R.id.roll)).getText().toString();
                String st[] = (new Manage(getContext())).getDetail(roll);
                if(st[0].equals("-1")) {
                    return;
                }
                v.findViewById(R.id.dtext).setVisibility(View.VISIBLE);
                v.findViewById(R.id.sdetail).setVisibility(View.VISIBLE);
                ((TextView)v.findViewById(R.id.sroll)).setText(st[0]);
                ((TextView)v.findViewById(R.id.sname)).setText(st[1]);
                ((TextView)v.findViewById(R.id.sclas)).setText(st[2]);
            }
        });
        return v;
    }
}