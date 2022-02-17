package com.example.tbtapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class tutorial extends AppCompatActivity {

    int count = 0;
    private ConstraintLayout parent;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        parent = (ConstraintLayout)findViewById(R.id.la);
        btn = (ImageButton)findViewById(R.id.tuEndBtn);
        final TextView text = (TextView)findViewById(R.id.tuText);
        final TextView text2 = (TextView)findViewById(R.id.tuText2);
        final TextView text3 = (TextView)findViewById(R.id.tuText3);
        final TextView text4 = (TextView)findViewById(R.id.tuText4);
        final View view = (View)findViewById(R.id.tuView0);
        final View view1 = (View)findViewById(R.id.tuView1);
        final View view2 = (View)findViewById(R.id.tuView2);
        final View near = (View)findViewById(R.id.nearView);
        final View view3 = (View)findViewById(R.id.tuView3);
        final View view4 = (View)findViewById(R.id.tuView4);
        final View Shview = (View)findViewById(R.id.tuShopView0);
        final View Shview1 = (View)findViewById(R.id.tuShopView1);
        final View Shview2 = (View)findViewById(R.id.tuShopView2);
        final View Stview = (View)findViewById(R.id.tuStView);

        text3.setBackgroundResource(R.drawable.edge3);
        text3.setText(" TBT앱의 기본적인 튜토리얼을 시작합\n 니다.\n 다음으로 넘어가려면 현재 이 창을\n 누르시면 됩니다.");

        text4.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(count == 15){
                    text4.setText(" 영상 시청 후 위에서부터 순서대로 스트레칭을 진행하실 수 있습니다.");
                    count++;
                }
                else if(count == 16){
                    text4.setText(null);
                    text4.setBackgroundResource(R.drawable.noedge);
                    Stview.setBackgroundResource(R.drawable.noedge);
                    text3.setText(" 이것으로 TBT앱의 기본적인 튜토리얼이 끝났습니다.");
                    text3.setBackgroundResource(R.drawable.edge3);
                    count++;
                }
            }
        });

        text3.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(count == 0) {
                    text3.setText(" 좌측 상단의 X버튼을 누르시면\n 튜토리얼을 중간에 종료하실수 있습니\n 다.");
                    btn.setBackgroundResource(R.drawable.edge2_color);
                    count++;
                }
                else if(count == 1) {
                    text3.setText(" 현재 화면은 발 상태를 확인하는\n 메인 화면입니다.");
                    btn.setBackgroundResource(R.drawable.noedge);
                    count++;
                }
                else if(count == 2){
                    text3.setText(null);
                    text3.setBackgroundResource(R.drawable.noedge);
                    text.setText(" 이곳에서는 발의 각도와 설문조사를\n 통해 무지외반증의 가능성을 나타내어\n 줍니다.");
                    text.setBackgroundResource(R.drawable.edge3);
                    view.setBackgroundResource(R.drawable.edge2_color);
                    count++;
                }
                else if(count == 14){
                    text3.setText(null);
                    text3.setBackgroundResource(R.drawable.noedge);
                    text4.setText(" 이곳에서 스트레칭 영상들을 확인하실 수 있습니다.");
                    text4.setBackgroundResource(R.drawable.edge3);
                    Stview.setBackgroundResource(R.drawable.edge2_color);
                    count++;
                }
                else if(count == 17){
                    text3.setText(" 튜토리얼을 종료하고 메인화면으로 돌아갑니다.");
                    count++;
                }
                else if(count == 18){
                    finish();
                }
            }
        });

        text.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(count == 3){
                    text.setText(" 이전을 누르시면 새롭게 갱신되기 전\n 의 가능성을 표시하여 줍니다.");
                    view.setBackgroundResource(R.drawable.edge2_color);
                    view2.setBackgroundResource(R.drawable.edge2_color);
                    count++;
                }
                else if(count == 4){
                    text.setText(" 가까운 병원 버튼을 누르시면 현재\n 위치와 가까운 무지외반증 병원의\n 위치를 알려드립니다.");
                    view.setBackgroundResource(R.drawable.edge2_color);
                    view2.setBackgroundResource(R.drawable.noedge);
                    near.setBackgroundResource(R.drawable.edge2_color);
                    count++;
                }
                else if(count == 5){
                    text.setBackgroundResource(R.drawable.noedge);
                    near.setBackgroundResource(R.drawable.noedge);
                    text.setText(null);
                    text2.setBackgroundResource(R.drawable.edge3);
                    text2.setText(" 이곳에서는 발 사이즈 측정과 발 상태\n 관련 설문조사가 가능합니다.");
                    view.setBackgroundResource(R.drawable.noedge);
                    view1.setBackgroundResource(R.drawable.edge2_color);
                    count++;
                }
                else if(count == 8){
                    text.setText(" 이 버튼들은 쇼핑할 신발들의 종류를 나타냅니다.");
                    Shview.setBackgroundResource(R.drawable.edge2_color);
                    count++;
                }
                else if(count == 9){
                    text.setText(" 좌측에서부터 전체 종류, 운동화 종류, 구두 종류, 부츠 종류, 로퍼 종류를 확인하실 수 있습니다.");
                    Shview.setBackgroundResource(R.drawable.edge2_color);
                    count++;
                }
                else if(count == 10){
                    text.setText(null);
                    text.setBackgroundResource(R.drawable.noedge);
                    text2.setBackgroundResource(R.drawable.edge3);
                    text2.setText(" 이곳에서는 주로 많이 선택한 종류의 신발들을 보여줍니다.");
                    Shview.setBackgroundResource(R.drawable.noedge);
                    Shview1.setBackgroundResource(R.drawable.edge2_color);
                    count++;
                }
            }
        });

        text2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(count == 6){
                    text2.setText(" 발 사이즈 측정과 설문조사를 완료하\n 면 무지외반증 가능성과 발 각도, 발\n 사이즈가 표시됩니다.");
                    view3.setBackgroundResource(R.drawable.edge2_color);
                    view4.setBackgroundResource(R.drawable.edge2_color);
                    count++;
                }
                else if(count == 7){
                    text2.setText(null);
                    text2.setBackgroundResource(R.drawable.noedge);
                    text.setBackgroundResource(R.drawable.edge3);
                    text.setText("\n 이 화면은 신발 쇼핑 화면입니다.\n");
                    parent.setBackgroundResource(R.drawable.tushop);
                    view1.setBackgroundResource(R.drawable.noedge);
                    view3.setBackgroundResource(R.drawable.noedge);
                    view4.setBackgroundResource(R.drawable.noedge);
                    count++;
                }
                else if(count == 11){
                    text2.setText(" 신발 추천 버튼으로도 신발을 구매하실 수 있습니다.");
                    count++;
                }
                else if(count == 12){
                    text2.setText(" 우측 상단의 버튼은 찜 해둔 신발들을 모아보실 수 있습니다.");
                    Shview1.setBackgroundResource(R.drawable.noedge);
                    Shview2.setBackgroundResource(R.drawable.edge2_color);
                    count++;
                }
                else if(count == 13){
                    text2.setText(null);
                    text2.setBackgroundResource(R.drawable.noedge);
                    Shview2.setBackgroundResource(R.drawable.noedge);
                    text3.setText("\n 이 화면은 스트레칭 화면입니다.\n");
                    text3.setBackgroundResource(R.drawable.edge3);
                    parent.setBackgroundResource(R.drawable.tustretch);
                    count++;
                }
            }
        });
    }

    public  void endClick(View v){finish();}
}
