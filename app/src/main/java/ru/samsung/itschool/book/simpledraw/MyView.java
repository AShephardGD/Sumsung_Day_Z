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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        int y = 0;
        int x = 0;
        while (y < canvas.getHeight()) {
            canvas.drawLine(0, y,
                    this.getWidth(), y, paint);
            y++;
            canvas.drawLine(0, y,
                    this.getWidth(), y, paint);
            y += 50;
        }
        while (x < canvas.getWidth()) {
            canvas.drawLine(x, 0,
                    x, this.getHeight(), paint);
            x++;
            canvas.drawLine(x, 0,
                    x, this.getHeight(), paint);
            x += 50;
        }
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(this.getWidth(), 0, 500, paint);
        x = 0; y = 0;
        while (y < this.getHeight()) {
            canvas.drawLine(this.getWidth(), 0, 0, y, paint);
            y += 250;
        }
        while (x < this.getHeight()) {
            canvas.drawLine(this.getWidth(), 0, x, y, paint);
            x += 250;
        }
    }
}
