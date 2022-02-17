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

public class Start_Login extends AppCompatActivity {

    // DB
    DBHelper myDb;
    // 데이터 값
    UserData user;
    // 로그인
    EditText EditText_email, EditText_password;
    Button Button_login;
    TextView login_signup, Id_PwSearching;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myDb = new DBHelper(this);

        // 로그인
        Button_login = (Button)findViewById(R.id.Button_login);
        EditText_email = findViewById(R.id.EditText_email);
        EditText_password = findViewById(R.id.EditTExt_password);

        // 회원가입
        login_signup = (TextView)findViewById(R.id.login_signup);

        // 아이디 비번 찾기
        Id_PwSearching = (TextView)findViewById(R.id.Id_PwSearching);

        Login();
        Signup();
        Searching();
    }

    // 로그인
    public void Login() {
        Button_login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // insert user data
                String email = EditText_email.getText().toString();
                String password = EditText_password.getText().toString();

                // output DB data
                Cursor res = myDb.getAllData();
                if(res.getCount() == 0 || email.equals(null) || password.equals(null)) {
                    // show message
                    showMessage("Error","Nothing found");
                    return;
                }

                while(res.moveToNext()) {
                    // 사용자정보 (이메일, 비밀번호)가 일치하면
                    if(email.equals(res.getString(1)) &&
                            password.equals(res.getString(2))) {
                        // 다음 화면 이동
                        Intent intent = new Intent(Start_Login.this, activity_main.class);
                        user = new UserData(res.getString(0), email);
                        intent.putExtra("user", user);

                        startActivity(intent);
                        finish();
                        return;
                    }
                }
                showMessage("불일치", "회원정보를 확인해주십시오.");
            }
        });
    }

    // 회원가입
    public void Signup() {
        login_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_login = new Intent(Start_Login.this, signUp.class);
                startActivity(intent_login);
            }
        });
    }
    public void Searching() {
        Id_PwSearching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_login = new Intent(Start_Login.this, Checking_User.class);
                startActivity(intent_login);
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
