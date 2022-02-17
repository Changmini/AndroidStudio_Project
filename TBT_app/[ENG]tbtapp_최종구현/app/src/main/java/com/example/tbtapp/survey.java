package com.example.tbtapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class survey extends AppCompatActivity {

    final main_StateFoot main_stateFoot = new main_StateFoot();
    UserData user;
    Button btnfinish;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5,
            checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11,
            checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17,
            checkBox18, checkBox19, checkBox20, checkBox21, checkBox22, checkBox23,
            checkBox24, checkBox25;
    public int count; // 선택된 체크박스의 개수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey);
        Intent intent = getIntent();
        user = (UserData)intent.getSerializableExtra("user");

        btnfinish = (Button) findViewById(R.id.btnfinish);checkBox1 = (CheckBox) findViewById(R.id.checkBox1);checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);checkBox4 = (CheckBox) findViewById(R.id.checkBox4);checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);checkBox7 = (CheckBox) findViewById(R.id.checkBox7);checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
        checkBox9 = (CheckBox) findViewById(R.id.checkBox9);checkBox10 = (CheckBox) findViewById(R.id.checkBox10);checkBox11 = (CheckBox) findViewById(R.id.checkBox11);
        checkBox12 = (CheckBox) findViewById(R.id.checkBox12);checkBox13 = (CheckBox) findViewById(R.id.checkBox13);checkBox14 = (CheckBox) findViewById(R.id.checkBox14);
        checkBox15 = (CheckBox) findViewById(R.id.checkBox15);checkBox16 = (CheckBox) findViewById(R.id.checkBox16);checkBox17 = (CheckBox) findViewById(R.id.checkBox17);
        checkBox18 = (CheckBox) findViewById(R.id.checkBox18);checkBox19 = (CheckBox) findViewById(R.id.checkBox19);checkBox20 = (CheckBox) findViewById(R.id.checkBox20);
        checkBox21 = (CheckBox) findViewById(R.id.checkBox21);checkBox22 = (CheckBox) findViewById(R.id.checkBox22);checkBox23 = (CheckBox) findViewById(R.id.checkBox23);
        checkBox24 = (CheckBox) findViewById(R.id.checkBox24);checkBox25 = (CheckBox) findViewById(R.id.checkBox25);
        count = 0;
        skip_main(); // 완료 버튼 클릭 시, 메인 화면으로 돌아감
        choice(); // 체크박스 선택 시 count +1

    }

    void skip_main() {
        // int형 count를 String으로 타입 변환하여 main_count에 저장
        // main_count를 main으로 보내기
        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setCount(count);
                 Intent intent  = new Intent(survey.this, activity_main.class);
                 intent.putExtra("user",user);
                 startActivity(intent);
                 finish();
                 return;
            }
        });
    }
    void choice() {
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox1.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox2.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox3.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox4.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox5.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox6.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox7.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox8.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox9.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox10.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox11.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox12.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox13.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox14.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox15.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox16.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox17.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox18.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox19.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox20.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox21.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox22.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox23.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox24.isChecked() == true) {
                    count++;
                }
            }
        });
        checkBox25.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox25.isChecked() == true) {
                    count++;
                }
            }
        });
    }
}