package com.example.tbtapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;

public class shoes_whole extends AppCompatActivity {
    EditText editText;
    ImageButton Filter;
    GridView gridView;
    CheckBox checkBox_SIze, checkBox_Price;
    String shoes;
    Cursor cursor;

    ArrayList<Foot> list;
    FootListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoes_whole);

        checkBox_Price = findViewById(R.id.checkBox_Price);
        checkBox_SIze = findViewById(R.id.checkBox_SIze);
        editText = findViewById(R.id.frame_B);
        Filter = findViewById(R.id.filter);

        // RunningShoes
        // HighHeel
        // Loafers
        // Walker
        Intent intent = getIntent();
        shoes = intent.getStringExtra("shoes");
        shoesStyle(shoes);
        Filter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // RunningShoes
                // HighHeel
                // Loafers
                // Walker
                int SearchingButton = Integer.parseInt(editText.getText().toString());
                int noSelect = shoesType(shoes, SearchingButton);
                if(noSelect == -1)
                    shoesStyle(shoes);
            }
        });


    }
    void shoesStyle(String shoes){

        gridView = (GridView)findViewById(R.id.gridView);
        list = new ArrayList<> ();
        adapter = new FootListAdapter(this, R.layout.foot_items,list);
        gridView.setAdapter(adapter);

        Cursor cursor;
        // get all data from sqlite
        if(shoes.equals("whole"))
            cursor = activity_main.DBHelper_image.getAllData("SELECT * FROM FOOT");
        else
            cursor = activity_main.DBHelper_image.getAllData("SELECT * FROM FOOT WHERE kind='"+shoes+"'");

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
    int shoesType(String shoes, int value){

        gridView = (GridView)findViewById(R.id.gridView);
        list = new ArrayList<> ();
        adapter = new FootListAdapter(this, R.layout.foot_items,list);
        gridView.setAdapter(adapter);


        // get all data from sqlite
        if(shoes.equals("whole")) {
            if (checkBox_SIze.isChecked())
                cursor = activity_main.DBHelper_image.getAllData("SELECT * FROM FOOT WHERE " +
                        "size ='" + value + "'");
            else if (checkBox_Price.isChecked())
                cursor = activity_main.DBHelper_image.getAllData("SELECT * FROM FOOT WHERE " +
                        "price ='" + value + "'");
            else return -1;
        }
        else {
            if (checkBox_SIze.isChecked())
                cursor = activity_main.DBHelper_image.getAllData("SELECT * FROM FOOT WHERE " +
                        "kind ='" + shoes + "' AND size='" + value + "' ");
            else if (checkBox_Price.isChecked())
                cursor = activity_main.DBHelper_image.getAllData("SELECT * FROM FOOT WHERE " +
                        "kind ='" + shoes + "' AND price='" + value + "' ");
            else return -1;
        }

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
        return 0;
    }


}
