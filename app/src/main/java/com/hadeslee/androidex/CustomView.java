package com.hadeslee.androidex;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
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

/*      canvas.drawColor(Color.GRAY);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawPoint(110, 110, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawLine(50, 50, 100, 100, paint);

        paint.setColor(Color.BLUE);
        canvas.drawRect(150, 10, 250, 150, paint);

        paint.setColor(0x5000ffff);
        canvas.drawCircle(200, 200, 100, paint);*/

        canvas.drawColor(Color.LTGRAY);
        Paint pint = new Paint();

 /*       Resources resources = getResources();
        BitmapDrawable bitmapDrawable = (BitmapDrawable) resources.getDrawable(R.drawable.wiz);
        Bitmap bitmap = bitmapDrawable.getBitmap();*/

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wiz);
        canvas.drawBitmap(bitmap, 5, 5, null);

    }
}
