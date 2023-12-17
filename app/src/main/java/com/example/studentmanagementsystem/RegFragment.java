package com.example.studentmanagementsystem;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class RegFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_reg, container, false);
        ((Button) v.findViewById(R.id.register)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roll = ((TextView) v.findViewById(R.id.roll)).getText().toString();
                String name = ((TextView) v.findViewById(R.id.name)).getText().toString();
                String clas = ((TextView) v.findViewById(R.id.clas)).getText().toString();
                (new Manage(getContext())).addDetail(roll, name, clas);
                Toast.makeText(getContext(), "Registration Successful!", Toast.LENGTH_LONG).show();

            }
        });
        return v;
    }
}