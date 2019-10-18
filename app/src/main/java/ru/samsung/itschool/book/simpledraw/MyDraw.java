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

    Paint paint = new Paint();
    int N = 500; // количество шариков
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];

    public MyDraw(Context context) {
        super(context);
        fillRandom(x, 0, 500);
        fillRandom(y, 0, 500);
        fillRandom(vx, -10, 50);
        fillRandom(vy, -10, 50);
    }


    float rand(float min , float max){
        return (float)(Math.random() * (max - min + 1)) + min;
    }

    void fillRandom(float[] array , float min, float max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }

    void add(float[] array , float[] values, int limit){
        for (int i = 0; i < array.length; i++){
            if (array[i] > limit || array[i] < 0) values[i] = -values[i];
            if (values[i] > 0) values[i] -= 0.005;
            else if (values[i] < 0) values[i] += 0.005;
            array[i] += values[i];
        }
    }

    void drawBalls(Canvas canvas){
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawBalls(canvas);
        add(x, vx, this.getWidth());
        add(y, vy, this.getHeight());
        invalidate();
    }
}