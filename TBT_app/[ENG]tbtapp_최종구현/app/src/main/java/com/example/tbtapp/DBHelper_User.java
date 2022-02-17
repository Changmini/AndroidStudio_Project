package com.example.tbtapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper_User extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "TBTuser.db";
    public static final String TABLE_NAME = "User";
    public static final String COL_0 = "NUM";
    public static final String COL_1 = "EMAIL";
    public static final String COL_2 = "FOOTSIZE";
    public static final String COL_3 = "BALLSIZE";
    public static final String COL_4 = "ANGLE";
    public static final String COL_5 = "SURVEY";
    public static final String COL_6 = "SCORE";


    public DBHelper_User(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (NUM INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, " +
                "FOOTSIZE TEXT, BALLSIZE TEXT, ANGLE TEXT, SURVEY INTEGER, SCORE TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String email,double footsize, double ballsize,
                              double angle, int survey, double score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, email);
        contentValues.put(COL_2, footsize);
        contentValues.put(COL_3, ballsize);
        contentValues.put(COL_4, angle);
        contentValues.put(COL_5, survey);
        contentValues.put(COL_6, score);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean insertData(int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_6, score);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select EMAIL, FOOTSIZE, BALLSIZE, ANGLE, SURVEY, SCORE from " + TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String name, String email,double footsize,
                              double ballsize, double angle, int survey, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, email);
        contentValues.put(COL_2, footsize);
        contentValues.put(COL_3, ballsize);
        contentValues.put(COL_4, angle);
        contentValues.put(COL_5, survey);
        contentValues.put(COL_6, score);
        db.update(TABLE_NAME, contentValues, "EMAIL = ?", new String[] { email });
        return true;
    }

    public Integer deleteData(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"EMAIL = ?", new String[] { email });
    }

}
