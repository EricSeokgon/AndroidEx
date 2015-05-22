package com.hadeslee.androidex;

import java.util.*;

import android.content.*;
import android.graphics.*;
import android.util.*;
import android.view.*;

public class CustomView extends View {

	public final static int CURRENT_CANVAS = 0;
	public final static int NEW_CAVAS = 1;

	private Context mContext;
	ArrayList<Dot> dots = new ArrayList<Dot>();
	private Paint paint;

	public CustomView(Context context) {
		super(context);
		initPaint(CustomView.CURRENT_CANVAS);
	}

	public CustomView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
		initPaint(CustomView.CURRENT_CANVAS);
	}

	public CustomView(Context context, AttributeSet attributeSet, int defStyle) {
		super(context, attributeSet, defStyle);
		initPaint(CustomView.CURRENT_CANVAS);
	}

	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// super.onDraw(canvas);

		canvas.drawColor(Color.WHITE);

		for (int i = 0; i < dots.size(); i++) {

			if (dots.get(i).isB()) {
				canvas.drawLine(dots.get(i - 1).getX(), dots.get(i - 1).getY(),
						dots.get(i).getX(), dots.get(i).getY(), paint);
			}

		}

	}

	public void initPaint(int i) {

		dots.clear();
		paint = null;
		paint = new Paint();
		paint.setColor(Color.GREEN);
		paint.setStrokeWidth(2);
		paint.setAntiAlias(true);
		
		if(i == CustomView.NEW_CAVAS) invalidate();

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			dots.add(new Dot(event.getX(), event.getY(), false));
			return true;
		}

		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			dots.add(new Dot(event.getX(), event.getY(), true));
			invalidate();
			return true;
		}

		return false;
	}

}
