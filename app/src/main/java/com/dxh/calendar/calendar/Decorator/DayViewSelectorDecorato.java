package com.dxh.calendar.calendar.Decorator;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

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

public class DayViewSelectorDecorato  implements DayViewDecorator {
    private final Drawable drawable;

    public DayViewSelectorDecorato(Activity context) {
       drawable= ContextCompat.getDrawable(context, R.drawable.day_view_selector);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return true;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setSelectionDrawable(drawable);
    }
}
