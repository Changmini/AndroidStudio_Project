package com.example.tbtapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DBHelper_Image extends SQLiteOpenHelper {


    public DBHelper_Image(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String kind, String name, String price, String size, String angle, byte[] image) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = "INSERT INTO FOOT VALUES (NULL, ?, ?, ?, ? ,?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, kind);
        statement.bindString(2, name);
        statement.bindString(3,price);
        statement.bindString(4,size);
        statement.bindString(5,angle);
        statement.bindBlob(6,image);

        statement.executeInsert();
    }

    public Cursor getAllData(String sql) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
