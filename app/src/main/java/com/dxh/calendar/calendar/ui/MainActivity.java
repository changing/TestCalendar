package com.dxh.calendar.calendar.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.style.ForegroundColorSpan;

import com.dxh.calendar.calendar.CalendarDay;
import com.dxh.calendar.calendar.DayViewDecorator;
import com.dxh.calendar.calendar.DayViewFacade;
import com.dxh.calendar.calendar.Decorator.DayViewSelectorDecorato;
import com.dxh.calendar.calendar.Decorator.HaveDataDayDecorator;
import com.dxh.calendar.calendar.Decorator.HightPressureDecorator;
import com.dxh.calendar.calendar.Decorator.MedicineDecorator;
import com.dxh.calendar.calendar.MedicineCalendarView;
import com.dxh.calendar.calendar.OnDateSelectedListener;
import com.dxh.calendar.calendar.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private MedicineCalendarView calendarView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        initView();
    }

    private void initView() {
        calendarView = (MedicineCalendarView) findViewById(R.id.calendarView);
//        calendarView.addDecorator(new TodayDecorator());


        Calendar maxCalendar=Calendar.getInstance();
        maxCalendar.set(maxCalendar.get(Calendar.YEAR),maxCalendar.get(Calendar.MONTH),31);
        calendarView.state().edit().setMaximumDate(maxCalendar).commit();
        calendarView.addDecorators(new DayViewSelectorDecorato(this),new HaveDataDayDecorator(context));
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MedicineCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        new ApiSimulator().executeOnExecutor(Executors.newSingleThreadExecutor());
        calendarView.addDecorator(new TodayDecorator());
    }

    private class TodayDecorator implements DayViewDecorator {

        private final CalendarDay today;
        private final Drawable backgroundDrawable;

        public TodayDecorator() {
            today = CalendarDay.today();
            backgroundDrawable = ContextCompat.getDrawable(context,R.mipmap.icon_today);
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return today.equals(day);
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.addSpan(new ForegroundColorSpan(Color.WHITE));
            view.setBackgroundDrawable(backgroundDrawable);
        }
    }


    /**
     * Simulate an API call to show how to add decorators
     */
    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -5);
            ArrayList<CalendarDay> dates = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                CalendarDay day = CalendarDay.from(calendar);
                dates.add(day);
                calendar.add(Calendar.DATE, 11);
            }

            return dates;
        }

        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);

            if (isFinishing()) {
                return;
            }

            calendarView.addDecorator(new MedicineDecorator(calendarDays,context));
            calendarView.addDecorator(new HightPressureDecorator(context,calendarDays));
        }
    }
}
