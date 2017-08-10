package com.dxh.calendar.calendar.Decorator;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.style.ForegroundColorSpan;

import com.dxh.calendar.calendar.CalendarDay;
import com.dxh.calendar.calendar.DayViewDecorator;
import com.dxh.calendar.calendar.DayViewFacade;
import com.dxh.calendar.calendar.R;

/**
 * @ClassNmae:
 * @Description:
 * @Athor: rosalind
 * @Email: xiaohong.deng@changhong.com
 * @Date： Careted on 2017/7/7
 */

public class HaveDataDayDecorator implements DayViewDecorator {
    Context context;

    public HaveDataDayDecorator(Context context) {
        this.context = context;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return PRIME_TABLE[day.getDay()];
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setDaysDisabled(false);
        view.addSpan(new ForegroundColorSpan(ContextCompat.getColor(context,R.color.color_green)));
    }

    private static boolean[] PRIME_TABLE = {
            false,  // 0?
            false,
            true, // 2
            true, // 3
            false,
            true, // 5
            false,
            true, // 7
            false,
            false,
            false,
            true, // 11
            false,
            true, // 13
            false,
            false,
            false,
            true, // 17
            false,
            true, // 19
            false,
            false,
            false,
            true, // 23
            false,
            false,
            false,
            false,
            false,
            true, // 29
            false,
            true, // 31
            false,
            false,
            false, //PADDING
    };
}
