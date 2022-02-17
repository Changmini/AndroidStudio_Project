package com.example.tbtapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Video3 extends AppCompatActivity {
    private int setcount = 5;
    private TextView setTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video3);

        setTxt = (TextView)findViewById(R.id.setView);

        final VideoView vv = (VideoView) findViewById(R.id.videoView);
        MediaController mediaCon = new MediaController(this);
        mediaCon.setAnchorView(vv);
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/raw/stvideo3_1");
        vv.setMediaController(mediaCon);
        vv.setVideoURI(video);
        vv.requestFocus();
        vv.start();
    }

    public  void start(View v)
    {
        if(setcount==0){
            AlertDialog.Builder alert = new AlertDialog.Builder(Video3.this);
            alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alert.setMessage("운동을 완료하였습니다.");
            alert.show();
        }
        else {
            setcount--;
            if(setcount==0)
                setTxt.setText("운동 완료!");
            else
                setTxt.setText(String.valueOf(setcount).concat("세트 남음"));
        }
    }

    public  void onBackButtonClick(View v)
    {
        finish();
    }
}
