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
        Task.showMessage(getContext(), "Если что, я хотел золотое сечение,но вышло что получше. Или хуже)))))");
        Paint paint = new Paint();
        int y = 0, x = 0, fb, fb1 = 1, fb2 = 0;
        for (int i = 0; i < 1000; i++) {
            fb = fb1 + fb2;
            canvas.drawLine((float) (540 + Math.cos(i/500)* i), (float)(960 + Math.sin(i/500) * i),
                    (float) (540 + Math.cos(i+1/500)* (i + 1)), (float) (960 + Math.sin(i+1/500) * (i + 1)), paint);
            fb2 = fb1;
            fb1 = fb;
        }


    }
}
