package com.dxh.calendar.calendar.Decorator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;

import com.dxh.calendar.calendar.R;

/**
 * @ClassNmae:
 * @Description:
 * @Athor: rosalind
 * @Email: xiaohong.deng@changhong.com
 * @Date： Careted on 2017/7/7
 */

public class MedicineSpan implements LineBackgroundSpan {
    private Context context;
    private int BitmapRes;

    public MedicineSpan(Context context) {
        this.context = context;
    }

    public MedicineSpan(Context context, int bitmapRes) {
        this.context = context;
        BitmapRes = bitmapRes;
    }

    @Override
    public void drawBackground(Canvas c, Paint p, int left, int right, int top, int baseline, int bottom, CharSequence text, int start, int end, int lnum) {
        Bitmap b= BitmapFactory.decodeResource(context.getResources(),R.mipmap.icon_no_medicine);
        c.drawBitmap(b,(left+right)/2-b.getWidth()/2,bottom+10,p);
    }
}
