package com.kimeeo.pagecurl.curl.provider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.kimeeo.pagecurl.R;

/**
 * Created by rjhy on 14-11-26.
 */
public class PageProvider3 extends TextPageProvider {
    private Context context;
    private Bitmap background;
    public PageProvider3(Context context) {
        this.context = context;
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);
    }
    @Override
    public void drawBackground(Canvas c, Rect r, int index, boolean isBack) {
        //draw color
//        Paint p = new Paint();
//        p.setColor(0xFF00FF00);
//        c.drawRect(r, p);

        c.drawBitmap(background, null, r, new Paint());
    }
}
