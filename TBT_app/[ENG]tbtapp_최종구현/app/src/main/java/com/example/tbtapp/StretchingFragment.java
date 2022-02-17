package com.example.tbtapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class StretchingFragment extends Fragment {
    Button STbutton1;
    Button STbutton2;
    Button STbutton3;

    public StretchingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_stretching, container, false);

        STbutton1 = (Button)rootView.findViewById(R.id.STbutton1);
        STbutton2 = (Button)rootView.findViewById(R.id.STbutton2);
        STbutton3 = (Button)rootView.findViewById(R.id.STbutton3);

        STbutton1.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Video1.class);
                startActivity(intent);
            }
        });
        STbutton2.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Video2.class);
                startActivity(intent);
            }
        });
        STbutton3.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Video3.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

}
