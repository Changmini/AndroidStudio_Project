package com.example.tbtapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;

public class activity_main extends AppCompatActivity {

    public static UserData user;
    public static DBHelper_Image DBHelper_image;
    public static DBHelper_User DBHelper_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터베이스 선언
        // 신발 데이터베이스
        DBHelper_image = new DBHelper_Image(this, "Shoes", null, 1);
        DBHelper_image.queryData("CREATE TABLE IF NOT EXISTS FOOT (Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "kind VARCHAR, name VARCHAR, price VARCHAR, size VARCHAR, angle VARCHAR, image BLOG)");
        // 사용자 데이터베이스 선언
        DBHelper_user = new DBHelper_User(this);

        // User 발사이즈 관련 데이터 받기
        Intent intent = getIntent();
        user = (UserData)intent.getSerializableExtra("user");

        // 튜토리얼
        // 사용자가 첫 이용자인지 확인하는 코드
        Cursor cursor = DBHelper_user.getAllData();
        int count=0;
        while(cursor.moveToNext()){
            if(user.getEmail().equals(cursor.getString(0)))
                count++;
        }
        // 처음 사용하는 사람이 아닐 경우
        if(count < 1) {
            AlertDialog.Builder alert_confirm = new AlertDialog.Builder(activity_main.this);
            alert_confirm.setMessage("이 앱을 처음 사용하시나요?\n(예를 누르시면 튜토리얼을 진행합니다.)").setCancelable(false).setPositiveButton("아니요",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 'No'
                            return;
                        }
                    }).setNegativeButton("예",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 'Yes'
                            Intent intent = new Intent(activity_main.this, tutorial.class);
                            startActivity(intent);
                        }
                    });
            AlertDialog alert = alert_confirm.create();
            alert.show();
        }


        // Fragment 이동을 위한 선언
        BottomNavigationView navigationView = findViewById(R.id.bottom_button);
        final main_StateFoot main_stateFoot = new main_StateFoot();
        final ShoesGoodsFragment shoesGoodsFragment = new ShoesGoodsFragment();
        final StretchingFragment stretchingFragment = new StretchingFragment();
        final MymenuFragment mymenuFragment = new MymenuFragment();

        // Fragment 버튼을 통한 화면 이동
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.screen_statefoot) {
                    setFragment(main_stateFoot);
                    return true;
                } else if(id == R.id.screen_shoesgods) {
                    setFragment(shoesGoodsFragment);
                    return true;
                }else if(id == R.id.screen_stretching) {
                    setFragment(stretchingFragment);
                    return true;
                }else if(id == R.id.screen_mymenu) {
                    setFragment(mymenuFragment);
                    return true;
                }
                return false;
            }
        });

        // Fragment 초기 화면 설정
        navigationView.setSelectedItemId((R.id.screen_statefoot));



    }

    // Fragment 화면 이동에 필요한 메서드
    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }
    private void removeFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }
}
