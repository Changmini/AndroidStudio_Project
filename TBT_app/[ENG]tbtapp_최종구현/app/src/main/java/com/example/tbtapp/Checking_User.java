package com.example.tbtapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Checking_User extends AppCompatActivity {

    DBHelper myDb;
    // 아이디 / 비번 찾기
    EditText  signup_name, signup_phone, signup_email, signup_phone2;
    Button Id_Searching, Pw_Searching, btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);

        myDb = new DBHelper(this);

        signup_name = findViewById(R.id.signup_name);
        signup_phone = findViewById(R.id.signup_phone);
        signup_email = findViewById(R.id.signup_email);
        signup_phone2 = findViewById(R.id.signup_phone2);
        // 찾기 버튼
        Id_Searching = findViewById(R.id.Id_Searching);
        Pw_Searching = findViewById(R.id.Pw_Searching);
        // 종료 버튼
        btn_close = findViewById(R.id.btn_close);

        Searching();
        Close();
    }
    public void Close(){
        btn_close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void Searching() {
        Id_Searching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = signup_name.getText().toString();
                String phone = signup_phone.getText().toString();

                // 이메일 정보 찾기
                Cursor res = myDb.getAllData();
                // 어떠한 이메일(회원)도 존재하지 않을 시
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Error","Nothing found");
                    return;
                }
                // 유저 아이디 검색
                while(res.moveToNext()) {
                    // 사용자정보 (이메일)가 일치하면
                    if(name.equals(res.getString(0)) &&
                            phone.equals(res.getString(3))) {
                        // 아이디 정보 발송
                        Id_Searching.setText(res.getString(1));
                        return;
                    }
                    else{
                        Toast.makeText(Checking_User.this, "입력하신 정보가 잘못 되었습니다..", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
            }
        });
        Pw_Searching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = signup_email.getText().toString();
                String phone2 = signup_phone2.getText().toString();

                // 비밀번호 정보 찾기
                Cursor res = myDb.getAllData();
                // 어떠한 이메일(회원)도 존재하지 않을 시
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Error","Nothing found");
                    return;
                }
                // 유저 비번 검색
                while(res.moveToNext()) {
                    // 사용자정보 (이메일)가 일치하면
                    if(email.equals(res.getString(1)) &&
                            phone2.equals(res.getString(3))) {
                        // 비번 정보 발송
                        Pw_Searching.setText(res.getString(2));
                        return;
                    }
                    else{
                        Toast.makeText(Checking_User.this, "입력하신 정보가 잘못 되었습니다..", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
            }
        });
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}