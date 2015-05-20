package com.hadeslee.androidex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by sklee on 2015-05-20.
 */
public class CustomView extends View {

    public CustomView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        canvas.drawColor(Color.GREEN);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(100, 100, 50, paint);

        paint.setColor(Color.RED);

        canvas.drawCircle(200, 200, 70, paint);

    }
}
