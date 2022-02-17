package com.example.tbtapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "TBT.db";
    public static final String TABLE_NAME = "Login";
    public static final String COL_0 = "NUM";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "ID";
    public static final String COL_3 = "PASSWORD";
    public static final String COL_4 = "PHONE";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (NUM INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, ID TEXT, PASSWORD TEXT, PHONE TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String email, String password, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, password);
        contentValues.put(COL_4, phone);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select NAME, ID, PASSWORD, PHONE from " + TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String email, String name, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, email);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, password);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] { email });
        return true;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?", new String[] { id });
    }

}
