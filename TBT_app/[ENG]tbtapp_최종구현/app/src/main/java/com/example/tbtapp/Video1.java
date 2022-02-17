package com.example.tbtapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Video1 extends AppCompatActivity {

    private static final int MILLISINFUTURE = 31 * 1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;

    private int count = 30;
    private char c = '"';
    private int setcount = 5;
    private TextView countTxt;
    private TextView setTxt;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video1);

        countTxt = (TextView) findViewById(R.id.timerView);
        setTxt = (TextView) findViewById(R.id.setView);

        final VideoView vv = (VideoView) findViewById(R.id.videoView);
        MediaController mediaCon = new MediaController(this);
        mediaCon.setAnchorView(vv);
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/raw/stvideo1_1");
        vv.setMediaController(mediaCon);
        vv.setVideoURI(video);
        vv.requestFocus();
        vv.start();
    }

    public void start(View v) {
        if (setcount == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(Video1.this);
            alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alert.setMessage("스트레칭을 완료하였습니다.\n다음 운동을 진행해주세요.");
            alert.show();
        } else {
            countDownTimer();
            countDownTimer.start();
        }
    }

    public void countDownTimer() {
        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                countTxt.setText(String.valueOf(count).concat(String.valueOf(c)));
                count--;
            }

            @Override
            public void onFinish() {
                count = 30;
                setcount--;
                setTxt.setText(String.valueOf(setcount).concat("세트 남음"));
                countTxt.setText(String.valueOf(count).concat(String.valueOf(c)));

                if (setcount == 0) {
                    setTxt.setText("스트레칭 완료!");
                }
            }
        };
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            countDownTimer.cancel();
        } catch (Exception e) {
        }
        countDownTimer = null;
    }

    public void onBackButtonClick(View v) {
        finish();
    }
}