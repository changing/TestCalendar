package com.dxh.calendar.calendar.Decorator;

import android.content.Context;

import com.dxh.calendar.calendar.CalendarDay;
import com.dxh.calendar.calendar.DayViewDecorator;
import com.dxh.calendar.calendar.DayViewFacade;

import java.util.Collection;
import java.util.HashSet;

/**
 * @ClassNmae:
 * @Description:
 * @Athor: rosalind
 * @Email: xiaohong.deng@changhong.com
 * @Date： Careted on 2017/7/7
 */

public class MedicineDecorator implements DayViewDecorator {

    private HashSet<CalendarDay > dates;
    private Context context;

    public MedicineDecorator(Collection<CalendarDay> dates, Context context) {
        this.dates = new HashSet<>(dates);
        this.context = context;
    }

    public MedicineDecorator(HashSet<CalendarDay> dates) {
        this.dates = dates;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new MedicineSpan(context));
    }
}
