package com.example.studentmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Manage extends SQLiteOpenHelper {
    private static final String DNAME = "database";
    private static final String TABLE = "STUDENT_DETAIL";
    private static final String NAME = "NAME";
    private static final String ROLL = "ROLL";
    private static final String CLAS = "CLASS";
    private static final int VERSION = 1;
    private Context context;
    public Manage(@Nullable Context context) {
        super(context, DNAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table = "CREATE TABLE " + TABLE + " (" + ROLL + " TEXT PRIMARY KEY," +
                NAME + " TEXT," +
                CLAS + " TEXT" +
                ")";
        sqLiteDatabase.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addDetail(String roll, String name, String clas) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ROLL, roll);
        cv.put(NAME, name);
        cv.put(CLAS, clas);
        db.insert(TABLE, null, cv);
    }

    public String[] getDetail(String roll) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " + TABLE + " WHERE " + ROLL + " = " + roll, null);
        if(cur.getCount() == 0) {
            Toast.makeText(context, "Record not found!", Toast.LENGTH_LONG).show();
            String st[] = new String[1];
            st[0] = "-1";
            return st;
        }
        cur.moveToFirst();
        String st[] = new String[3];
        st[0] = roll;
        st[1] = cur.getString(1);
        st[2] = cur.getString(2);
        return st;
    }

    public void delete(String roll) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE, ROLL + " = " + roll, null);
    }

    public ArrayList<ArrayList<String>> getTable() {
        ArrayList<ArrayList<String>> whole_table = new ArrayList<ArrayList<String>>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " + TABLE, null);

        while(cur.moveToNext()) {
            ArrayList<String> st = new ArrayList<>();
            st.add(cur.getString(0));
            st.add(cur.getString(1));
            st.add(cur.getString(2));
            whole_table.add(st);
        }
        return whole_table;
    }
}
