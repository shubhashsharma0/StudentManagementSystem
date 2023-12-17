package com.example.studentmanagementsystem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class UpdFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_upd, container, false);
        ((Button) v.findViewById(R.id.search)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roll = ((EditText)v.findViewById(R.id.roll)).getText().toString();
                String st[] = (new Manage(getContext())).getDetail(roll);
                if(st[0].equals("-1")) {
                    return;
                }
                (v.findViewById(R.id.sdetail)).setVisibility(View.VISIBLE);
                ((TextView)v.findViewById(R.id.sroll)).setText(st[0]);
                ((TextView)v.findViewById(R.id.sname)).setText(st[1]);
                ((TextView)v.findViewById(R.id.sclas)).setText(st[2]);

            }
        });
        ((Button) v.findViewById(R.id.upd)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (v.findViewById(R.id.sdetail)).setVisibility(View.INVISIBLE);
                String roll = ((TextView)v.findViewById(R.id.sroll)).getText().toString();
                (new Manage(getContext())).delete(roll);
                roll = ((TextView) v.findViewById(R.id.sroll)).getText().toString();
                String name = ((TextView) v.findViewById(R.id.sname)).getText().toString();
                String clas = ((TextView) v.findViewById(R.id.sclas)).getText().toString();
                (new Manage(getContext())).addDetail(roll, name, clas);
                Toast.makeText(getContext(), "Updated Successful!", Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
}