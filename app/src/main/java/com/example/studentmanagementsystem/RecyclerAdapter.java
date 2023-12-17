package com.example.studentmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<ArrayList<String>> al;

    RecyclerAdapter(Context context, ArrayList<ArrayList<String>> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.ind_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArrayList<String> temp = al.get(position);
        holder.roll.setText(temp.get(0));
        holder.name.setText(temp.get(1));
        holder.clas.setText(temp.get(2));
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView roll, name, clas;

        public ViewHolder(@NonNull View view) {
            super(view);
            roll = view.findViewById(R.id.sroll);
            name = view.findViewById(R.id.sname);
            clas = view.findViewById(R.id.sclas);
        }
    }
}

