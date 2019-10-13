package ru.samsung.itschool.book.simpledraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyDraw extends View {

    int N = 100; // количество шариков
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    public MyDraw(Context context) {
        super(context);
        for (int i = 0; i < N; i++) {
            x[i] = (float) (Math.random() * 500);
            y[i] = (float) (Math.random() * 500);
            vx[i] = (float) (Math.random() * 60 - 30);
            vy[i] = (float) (Math.random() * 60 - 30);
        }
    }

    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        // отрисовываем все шарики
        for (int i = 0; i < N - 1; i++) {
            canvas.drawLine(x[i], y[i], x[i + 1], y[i + 1], paint);
            if(i % 6 == 0) paint.setColor(Color.GREEN);
            if(i % 6 == 1) paint.setColor(Color.YELLOW);
            if(i % 6 == 2) paint.setColor(Color.BLUE);
            if(i % 6 == 3) paint.setColor(Color.RED);
            if(i % 6 == 4) paint.setColor(Color.MAGENTA);
            if(i % 6 == 5) paint.setColor(Color.CYAN);

        }
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 20, paint);
            if(i % 6 == 0) paint.setColor(Color.GREEN);
            if(i % 6 == 1) paint.setColor(Color.YELLOW);
            if(i % 6 == 2) paint.setColor(Color.BLUE);
            if(i % 6 == 3) paint.setColor(Color.RED);
            if(i % 6 == 4) paint.setColor(Color.MAGENTA);
            if(i % 6 == 5) paint.setColor(Color.CYAN);
        }
        // готовим массивы x и у для следущего кадра
        for (int i = 0; i < N; i++) {
            if (x[i] < 0 || x[i] > this.getWidth()) vx[i] = - vx[i];
            if (y[i] < 0 || y[i] > this.getHeight()) vy[i] = - vy[i];
            x[i] += vx[i];
            y[i] += vy[i];
        }
        // Запрос на перерисовку экрана
        invalidate();
    }
}