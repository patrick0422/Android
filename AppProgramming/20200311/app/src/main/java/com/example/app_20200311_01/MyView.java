package com.example.app_20200311_01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    int key;
    String str;

    int x, y;

    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        x = (int)event.getX(0);
        y = (int)event.getY(0);

        invalidate();

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();
        paint.setTextSize(50);
        canvas.drawCircle(x, y, 30, paint);
        canvas.drawText("(" + x + ", " + y + ") 에서 터치 이벤트가 발생하였음", x, y + 100, paint);
    }
}
