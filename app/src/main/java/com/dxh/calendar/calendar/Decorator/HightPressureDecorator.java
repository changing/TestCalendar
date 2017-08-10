package com.dxh.calendar.calendar.Decorator;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.style.ForegroundColorSpan;

import com.dxh.calendar.calendar.CalendarDay;
import com.dxh.calendar.calendar.DayViewDecorator;
import com.dxh.calendar.calendar.DayViewFacade;
import com.dxh.calendar.calendar.R;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * @ClassNmae:
 * @Description:
 * @Athor: rosalind
 * @Email: xiaohong.deng@changhong.com
 * @Date： Careted on 2017/7/7
 */

public class HightPressureDecorator implements DayViewDecorator {
    private HashSet<CalendarDay> dates;
    private Context context;

    public HightPressureDecorator(Context context, Collection<CalendarDay> dates) {
        this.dates = new HashSet<>(dates);
        this.context=context;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new ForegroundColorSpan(Color.WHITE));
        view.setBackgroundDrawable(ContextCompat.getDrawable(context, R.mipmap.icon_unhealth_bg));
    }
}
