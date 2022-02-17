package com.example.tbtapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.media.Image;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class DrawLine extends View
{
    //현재 그리기 조건(색상, 굵기, 등등.)을 기억 하는 변수.
    private Paint paint = null;
    //그리기를 할 bitmap 객체. -- 도화지라고 생각하면됨.
    private Bitmap bitmap = null;
    //bitmap 객체의 canvas 객체. 실제로 그리기를 하기 위한 객체.. -- 붓이라고 생각하면됨.
    private Canvas canvas = null;
    //마우스 포인터(손가락)이 이동하는 경로 객체.
    private Path path;
    //마우스 포인터(손가락)이 가장 마지막에 위치한 x좌표값 기억용 변수.
    private float oldX, newX;
    //마우스 포인터(손가락)이 가장 마지막에 위치한 y좌표값 기억용 변수.
    private float oldY, newY;

    boolean ch_firstline = true;
    boolean ch_secline = true;
    public static double realBalBoll,realBallSize,muji_fin;
    public double firstline;
    public double secondline;
    double muji1, muji2;


    double h, w ;

    public DrawLine(Context context, Rect rect)
    {
        this(context);
        //그리기를 할 bitmap 객체 생성.
        bitmap = Bitmap.createBitmap(rect.width(), rect.height(),
                Bitmap.Config.ARGB_8888);
        //그리기 bitmap에서 canvas를 알아옴.
        canvas = new Canvas(bitmap);
        //경로 초기화.
        path = new Path();


    }

    @Override
    protected void onDetachedFromWindow()
    {
        //앱 종료시 그리기 bitmap 초기화 시킴...
        if(bitmap!= null) bitmap.recycle();
        bitmap = null;
        super.onDetachedFromWindow();
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        //그리기 bitmap이 있으면 현재 화면에 bitmap을 그린다.
        //자바의 view는 onDraw할때 마다 화면을 싹 지우고 다시 그리게 됨.
        if(bitmap != null)
        {
            canvas.drawBitmap(bitmap, 0, 0, null);
        }
    }

    //이벤트 처리용 함수..
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float x = event.getX();
        float y = event.getY();


        switch (event.getAction() & MotionEvent.ACTION_MASK)
        {
            case MotionEvent.ACTION_DOWN:
            {
                //포인터 위치값을 기억한다.
                oldX = x;
                oldY = y;
                //계속 이벤트 처리를 하겠다는 의미.
                return true;
            }
            case MotionEvent.ACTION_UP:
            {
                //포인트가 이동될때 마다 두 좌표(이전에눌렀던 좌표와 현재 이동한 좌료)간의 간격을 구한다.
                float dx = Math.abs(x - oldX);
                float dy = Math.abs(y - oldY);

                //두 좌표간의 간격이 4px이상이면 (가로든, 세로든) 그리기 bitmap에 선을 그린다.
                if (dx >= 4 || dy >= 4)
                {
                    //포인터의 마지막 위치값을 기억한다.
                    newX = x;
                    newY = y;

                    //발 사이즈
                    if (ch_firstline == true && ch_secline == true)
                    {
                        canvas.drawLine(oldX,oldY, oldX, newY, paint);
                        ch_firstline = false;
                        firstline = newY-oldY;
                        realBallSize = secondline*297; // DB 발 사이즈 넣어주세용
                        //h는 사진의 세로길이
                    }

                    //발 볼
                    else if (ch_firstline == false && ch_secline == true)
                    {
                        canvas.drawLine(oldX,oldY, newX, oldY, paint);
                        ch_secline = false;
                        secondline = newX-oldX;
                        realBalBoll =  firstline*210; // DB 발 볼 넣어주세용
                        //w는 사진의 가로길이

                    }

                    //무지외반증1
                    else if(ch_firstline == false && ch_secline == false)
                    {
                        canvas.drawLine(oldX,oldY, oldX, newY, paint);
                        ch_firstline = true;
                        muji1 = newY-oldY;
                    }

                    //무지외반증1
                    else if(ch_firstline == true && ch_secline == false)
                    {
                        canvas.drawLine(oldX,oldY, newX, newY, paint);
                        ch_secline= true;
                        muji2 = Math.sqrt(Math.pow(newX-oldX,2)+ Math.pow(newY-oldY,2));
                            //DB에 무지외반증 각도 저장

                        double inner = oldX*oldX + oldY*oldY;
                        float i1 = (float)Math.sqrt((oldX*oldX)+(oldY*oldY));
                        float i2 = (float)Math.sqrt((newX*newX)+(newY*newY));
                        oldX = (float)oldX/i1;
                        oldY = (float)oldY/i2;
                        newX = (float)newX/i1;
                        newY = (float)newY/i2;
                        inner = (newX*oldX) + (newY+newX);
                        muji_fin = Math.acos(inner)*190/Math.PI;   //무지외반증 각도

                    }
                }
                //화면을 갱신시킴.. 이 함수가 호출 되면 onDraw 함수가 실행됨.
                invalidate();
                //계속 이벤트 처리를 하겠다는 의미.
                return true;
            }
        }
        //더이상 이벤트 처리를 하지 않겠다는 의미.
        return false;
    }
    /* 펜 색상 세팅*/
    public void setLineColor(int color)
    {
        paint = new Paint();
        paint.setColor(color);
        paint.setAlpha(255);
        paint.setDither(true);
        paint.setStrokeWidth(5);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
    }
    public DrawLine(Context context)
    {
        super(context);
    }


}

