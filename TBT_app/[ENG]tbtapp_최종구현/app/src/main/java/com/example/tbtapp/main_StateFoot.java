package com.example.tbtapp;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class main_StateFoot extends Fragment {

    // 사용자 정보
    static UserData user;

    TextView tvadvice;
    TextView tvpercent;
    TextView tvangle;
    TextView tvsize;
    TextView tvlast;
    Button btntest,btnHos, btnCamera;
    int survey_count;
    double camera_Ang=0, camera_Foot=0, camera_Ball;
    ViewGroup rootView;

    int possibility; // 가능성 (설문조사 50,각도 50 )
    int angle_count; // 각도 점수 일반 사람 : 3도부터 +0.24도 될 때마다 가능성 +1, 15도 부터는 각도는 50

    static String test = null;

    public main_StateFoot() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main_state_foot, container, false);

        btnCamera = (Button)rootView.findViewById(R.id.btnCamera);
        btntest = (Button)rootView.findViewById(R.id.btntest);
        btnHos = (Button)rootView.findViewById(R.id.btnHos);

        tvadvice = (TextView)rootView.findViewById(R.id.tvadvice);
        tvpercent = (TextView)rootView.findViewById(R.id.tvpercent);
        tvangle = (TextView)rootView.findViewById(R.id.tvangle);
        tvsize = (TextView)rootView.findViewById(R.id.tvsize);
        tvlast = (TextView)rootView.findViewById(R.id.tvlast);

        // 사용자(user) 데이터 값을 저장
        user = activity_main.user;

        // 설문조사 값
        if(user.getCount() > 0)
            survey_count = user.getCount();
        // 사용자 발 사이즈, 각도 크기 값 출력
        if(user.getFootSIze() > 0 && user.getAngle() > 0) {
            tvsize.setText(user.getFootSIze()+""); // 발 사이즈 출력
            tvangle.setText(user.getFootSIze()+""); // 각도 출력
        }

        // 무지외반증 가능성 결과
        if (user.getAngle() > 0 && user.getCount() > 0) {
            angle_count = analyze(camera_Ang);
            possibility += (survey_count*2);
            possibility += angle_count;

            advice(possibility); // 조언
            // 사용자 정보 데이터베이스에 저장
            activity_main.DBHelper_user.insertData(user.getEmail(), user.getFootSIze(),
                    user.getBallSIze(), user.getAngle(), user.getCount(), possibility);
        }

        // 데이터베이스에서 결과값 가져오기
        Cursor res = activity_main.DBHelper_user.getAllData();
        // 측정 개수가 2개 이상이면
        if(res.getCount() < 2) {
            // 이전 데이타
            tvlast.setText("not data");
        }
        else {
            int allUserData=0, check=0;
            String id = user.getEmail();
            while (res.moveToNext()) {
                if(id.equals(res.getString(0))) {
                    allUserData++;
                    // 사용자 발사이즈, 각도, 무지외반증 이번 가능성, 현재 가능성 출력
                    tvsize.setText(res.getString(1)); // 발 사이즈 출력
                    tvangle.setText(res.getString(3)); // 각도 출력
                    tvpercent.setText(res.getString(5)); // 갱신된 가능성 수치 출력
                }
            }
            res = activity_main.DBHelper_user.getAllData();
            while (res.moveToNext()) { // 이전 데이터 찾긴
                if(id.equals(res.getString(0)))
                    check++;
                // 이전 데이터 가져오기
                if(allUserData - 1 == check &&
                        id.equals(res.getString(0))){
                    // 화면 출력
                    tvlast.setText(res.getString(5)+"");
                }
            }
        }






        // 클릭 이벤트
        skip_survey(); // 설문조사 실시
        Entered_Camera(); // 카메라 작동
        link_Hos(); // 가까운 병원 위치 구글맵 연결

        return rootView;
    }

    int analyze(double angle) {
        int num = 0;

        while (true)
        {
            if (angle > 3 && angle < 15)
                num++;
            else
                break;
            angle = angle - 0.24;
        }
        if (angle > 15)
            num = 50;
        return num;
    }

    void advice(int pb){
        tvadvice = (TextView)rootView.findViewById(R.id.tvadvice);
        int randomNum=(int)Math.random()*7; // 저위험군 0~7
        int randomNum2=(int)Math.random()*6+1;
        // 조언 13개 0~12
        String [] arrAdvice={"슬리퍼나 샌들은 발가락 고정이 되지 않으므로 무지외반증 완화에 효과가 없어요!\n","하이힐을 신고 싶다면 통굽이 더 좋아요!\n",
                "신발을 고를 때 발등과 발가락 부위가 넓은 신발이 좋아요!\n","회사에서는 편한 단화를 신는 것을 추천해요!\n",
                "잦은 깔창 사용은 좋지 않아요!\n","무지외반증에 도움이 되는 스트레칭을 시행해주세요!\n","변형을 악화시키는 신발을 피하고 발등과 발가락 부위가 넓고 굽이 낮은 신발을 착용하는 것이 좋아요\n"};

        String [] arrAdvice2={"병원 방문을 추천합니다!\n","변형을 악화시키는 신발을 피하고 발등과 발가락 부위가 넓고 굽이 낮은 신발을 착용하는 것이 좋아요\n",
                "교정기를 착용하는 것이 증상을 완화하는데 도움이 돼요\n","엄지발가락과 신발이 접촉되는 신발 부분을 수선하는 것도 좋아요!\n",
                "무지외반증에 도움이 되는 스트레칭을 주기적으로 시행해주세요!\n","평발이라면 발바닥 안쪽을 지지해주는 안창(안쪽 세로바닥활지지보조기)을 사용하면 앞발을 약간 회전시켜 무지외반증이 있는 부위에 가해지는 압력을 감소시킬 수 있어요\n"};
        if(pb<=25){
            tvadvice.setText(String.format("저위험군입니다!\n낮은 확률이라도 방심은 금물!\n"+arrAdvice[randomNum]));
        }
        else if(pb<=50){
            tvadvice.setText(String.format("중위험군입니다!\n"+arrAdvice[randomNum]+arrAdvice2[1]));
        }
        else if(pb<=80){
            tvadvice.setText(String.format("고위험군입니다!\n"+arrAdvice2[randomNum2]+arrAdvice2[0]));
        }
        else{
            tvadvice.setText(String.format("무지외반증이 의심됩니다!\n"+arrAdvice2[randomNum2]+arrAdvice2[0]));
        }
    }
    void skip_survey(){
        btntest.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), survey.class);
                intent.putExtra("user",user);
                startActivity(intent);
                getActivity().finish();
                return;
            }
        });
    }
    void Entered_Camera(){
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Camera.class);
                intent.putExtra("user",user);
                startActivity(intent);
                getActivity().finish();
                return;
            }
        });
    }
    void link_Hos(){
        btnHos =(Button)rootView.findViewById(R.id.btnHos);
        btnHos.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/?q=대전 서구 무지외반증 병원"));
                startActivity(intent);
            }
        });
    }
}
