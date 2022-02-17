package com.example.tbtapp;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShoesGoodsFragment extends Fragment {
    // 신발화면
    ImageButton whole;
    ImageButton runningShoes;
    ImageButton highHeel;
    ImageButton loafers;
    ImageButton walker;

    GridView gridView;
    ArrayList<Foot> list;
    FootListAdapter adapter = null;

    //찜 모아보기 화면
    ImageButton collection;

    public ShoesGoodsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_shoes_goods, container, false);

        // 신발 화면
        whole = (ImageButton)rootView.findViewById(R.id.whole);
        runningShoes = (ImageButton)rootView.findViewById(R.id.runningShoes);
        highHeel = (ImageButton)rootView.findViewById(R.id.highHeel);
        loafers = (ImageButton)rootView.findViewById(R.id.loafers);
        walker = (ImageButton)rootView.findViewById(R.id.walker);

        // 찜 모아보기 화면
        collection = (ImageButton)rootView.findViewById(R.id.collection);

        // 신발 화면
        // Whole
        whole.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), shoes_whole.class);
                intent.putExtra("shoes", "whole");
                startActivity(intent);
            }
        });
        // RunningShoes
        runningShoes.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), shoes_whole.class);
                intent.putExtra("shoes", "RunningShoes");
                startActivity(intent);
            }
        });
        // HighHeel
        highHeel.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), shoes_whole.class);
                intent.putExtra("shoes", "HighHeel");
                startActivity(intent);
            }
        });
        // Loafers
        loafers.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), shoes_whole.class);
                intent.putExtra("shoes", "Loafers");
                startActivity(intent);
            }
        });
        // Walker
        walker.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), shoes_whole.class);
                intent.putExtra("shoes", "Walker");
                startActivity(intent);
            }
        });

        // 찜 모아보기 화면
        collection.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), shoes_collection.class);
                startActivity(intent);
            }
        });

        gridView = (GridView)rootView.findViewById(R.id.gridView);
        list = new ArrayList<> ();
        adapter = new FootListAdapter(getActivity(), R.layout.foot_items,list);
        gridView.setAdapter(adapter);

        // get all data from sqlite
        Cursor cursor = activity_main.DBHelper_image.getAllData("SELECT * FROM FOOT");
        list.clear();
        int count = 0;
        while(cursor.moveToNext() && count < 4) {
            int id = cursor.getInt(0);
            String kind = cursor.getString(1);
            String name = cursor.getString(2);
            String price = cursor.getString(3);
            String size = cursor.getString(4);
            String angle = cursor.getString(5);
            byte[] image = cursor.getBlob(6);
            list.add(new Foot(kind, name, price, size, angle, image, id));
            count++;
        }
        adapter.notifyDataSetChanged();


        // Inflate the layout for this fragment
        return rootView;
    }
}
