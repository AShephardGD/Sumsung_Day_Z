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
        int y = 0, x = 0, xe = 0, ye = 0;
        while (y < this.getHeight() || x < this.getWidth()){
            if(xe < this.getWidth()) xe += 25;
            else ye += 25;
            if(y < this.getHeight()) y += 25;
            else x += 25;
            canvas.drawLine((float) x, y, xe, ye, paint);
        }
        y = 0; x = this.getWidth(); xe = this.getWidth(); ye = 0;
        while (y < this.getHeight() || x > 0){
            if(ye < this.getHeight()) ye += 25;
            else xe -= 25;
            if(x > 0) x -= 25;
            else y += 25;
            canvas.drawLine(xe, ye, x, y, paint);
        }
    }
}