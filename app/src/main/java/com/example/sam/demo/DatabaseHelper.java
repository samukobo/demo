package com.example.sam.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Sam on 05/04/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String database_name = "worklodi.db";
    public static final String table_worklodi = "worklodi_table";
    public static final String col_1 = "id";
    public static final String col_2 = "name";
    public static final String col_3 = "weeks";
    public static final String col_4 = "deadline";
    public static final String col_5 = "subj1";
    public static final String col_6 = "subj2";

    public DatabaseHelper(Context context){
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + table_worklodi + " (id integer primary key autoincrement, name text, weeks text, deadline text, subj1 text, subj2 text) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("drop table if exists " + table_worklodi);
        onCreate(db);
    }

    public boolean insertData(String name, String weeks, String deadline, String subj1, String subj2){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, name);
        contentValues.put(col_3, weeks);
        contentValues.put(col_4, deadline);
        contentValues.put(col_5, subj1);
        contentValues.put(col_6, subj2);
        long result = db.insert(table_worklodi, null, contentValues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + table_worklodi, null);
        return res;
    }

    public boolean updateData(String id, String name, String weeks, String deadline, String subj1, String subj2){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1, id);
        contentValues.put(col_2, name);
        contentValues.put(col_3, weeks);
        contentValues.put(col_4, deadline);
        contentValues.put(col_5, subj1);
        contentValues.put(col_6, subj2);

        db.update(table_worklodi, contentValues, "id = ?", new String[]{id});
        return true;

    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table_worklodi, "id = ?", new String[]{id});
    }


}
