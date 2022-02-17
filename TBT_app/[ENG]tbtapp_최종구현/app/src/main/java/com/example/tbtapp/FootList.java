package com.example.tbtapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FootList extends AppCompatActivity {

    GridView gridView;
    ArrayList<Foot> list;
    FootListAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoes_whole);

        gridView = (GridView)findViewById(R.id.gridView);
        list = new ArrayList<> ();
        adapter = new FootListAdapter(this, R.layout.foot_items,list);
        gridView.setAdapter(adapter);

        // get all data from sqlite
        Cursor cursor = shoes_collection.DBHelper_image.getAllData("SELECT * FROM FOOT");
        list.clear();
        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String kind = cursor.getString(1);
            String name = cursor.getString(2);
            String price = cursor.getString(3);
            String size = cursor.getString(4);
            String angle = cursor.getString(5);
            byte[] image = cursor.getBlob(6);
            list.add(new Foot(kind, name, price, size, angle, image, id));
        }
        adapter.notifyDataSetChanged();
    }
}
