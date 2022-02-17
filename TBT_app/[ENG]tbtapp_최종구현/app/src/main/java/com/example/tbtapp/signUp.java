package com.example.tbtapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    DBHelper myDb;
    // 회원가입
    TextView signup, test;
    EditText signup_email, signup_pw, signup_pwcheck, signup_username, signup_phone;
    Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        myDb = new DBHelper(this);

        signup_email = findViewById(R.id.signup_email);
        signup_pw = findViewById(R.id.signup_pw);
        signup_pwcheck = findViewById(R.id.signup_pwcheck);
        signup_username = findViewById(R.id.signup_username);
        signup_phone = findViewById(R.id.signup_phone);
        // 회원가입 버튼
        btn_signup = findViewById(R.id.btn_signup);

        Signup();

    }

    public void Signup() {
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = signup_username.getText().toString();
                String email = signup_email.getText().toString();
                String pw = signup_pw.getText().toString();
                String pwcheck = signup_pwcheck.getText().toString();
                String phone = signup_phone.getText().toString();

                // 비밀번호 일치여부
                if (!pw.equals(pwcheck)) {
                    showMessage("Error", "비밀번호를 확인해주세요.");
                    return;
                }
                Cursor res = myDb.getAllData();
                // 이메일 중복 방지
                while(res.moveToNext()) {
                    // 사용자정보 (이메일)가 일치하면
                    if(email.equals(res.getString(1))) {
                        // 이메일(아이디) 재입력 요청
                        Toast.makeText(signUp.this, "이미 존재하는 아이디입니다.", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                boolean isInserted = myDb.insertData(name, email, pw, phone);
                if (isInserted)
                    Toast.makeText(signUp.this, "데이터 정상 삽입", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(signUp.this, "데이터 삽입 중 문제발생", Toast.LENGTH_LONG).show();

                finish();
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