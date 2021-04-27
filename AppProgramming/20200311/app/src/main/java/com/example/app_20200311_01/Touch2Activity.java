package com.example.app_20200311_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Touch2Activity extends AppCompatActivity {
    protected class MaiView extends View {
        int x = 100, y = 100;

        String str;

        public MaiView(Context context) {
            super(context);
            setBackgroundColor(Color.WHITE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.YELLOW);
            canvas.drawCircle(x, y, 100, paint);
            paint.setTextSize(50);
            canvas.drawText("액션의 종류: " + str, 0, 100, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = (int)event.getX();
            y = (int)event.getY();

            if (event.getAction() == MotionEvent.ACTION_DOWN)
                str = "ACTION_DOWN";
            else if (event.getAction() == MotionEvent.ACTION_MOVE)
                str = "ACTION_MOVE";
            else if (event.getAction() == MotionEvent.ACTION_UP)
                str = "ACTION_UP";

            invalidate();

            return true;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MaiView(this));
    }
}