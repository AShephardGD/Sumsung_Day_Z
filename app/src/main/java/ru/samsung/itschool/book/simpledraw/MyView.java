package ru.samsung.itschool.book.simpledraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import task.Task;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }
    Paint paint = new Paint();
    float x, y, i;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(520, 960, 20, paint);
        canvas.drawCircle(520 + (100 * x), 960 + (100 * y), 20, paint);
        canvas.drawCircle(520 + (200 * x), 960 + (200 * y), 20, paint);
        canvas.drawCircle(520 + (300 * x), 960 + (300 * y), 20, paint);
        canvas.drawCircle(520 + (400 * x), 960 + (400 * y), 20, paint);
        canvas.drawCircle(520 - (100 * x), 960 - (100 * y), 20, paint);
        canvas.drawCircle(520 - (200 * x), 960 - (200 * y), 20, paint);
        canvas.drawCircle(520 - (300 * x), 960 - (300 * y), 20, paint);
        canvas.drawCircle(520 - (400 * x), 960 - (400 * y), 20, paint);
        canvas.drawCircle(520 - (100 * x), 960 + (100 * y), 20, paint);
        canvas.drawCircle(520 - (200 * x), 960 + (200 * y), 20, paint);
        canvas.drawCircle(520 - (300 * x), 960 + (300 * y), 20, paint);
        canvas.drawCircle(520 - (400 * x), 960 + (400 * y), 20, paint);
        canvas.drawCircle(520 + (100 * x), 960 - (100 * y), 20, paint);
        canvas.drawCircle(520 + (200 * x), 960 - (200 * y), 20, paint);
        canvas.drawCircle(520 + (300 * x), 960 - (300 * y), 20, paint);
        canvas.drawCircle(520 + (400 * x), 960 - (400 * y), 20, paint);

        i += 0.05f;
        x = (float) Math.cos(i); y = (float) Math.sin(i);
        invalidate();
    }
}
