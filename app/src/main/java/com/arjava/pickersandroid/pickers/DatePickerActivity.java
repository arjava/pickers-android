package com.arjava.pickersandroid.pickers;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.arjava.pickersandroid.R;

import java.util.Calendar;
import java.util.Objects;

public class DatePickerActivity extends AppCompatActivity {
    DatePicker simpleDatePicker;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        Objects.requireNonNull(getSupportActionBar()).setTitle("DatePickerWidget");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        simpleDatePicker = findViewById(R.id.datePickerWidget);
        simpleDatePicker.setSpinnersShown(true);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -3);
        simpleDatePicker.setMinDate(calendar.getTimeInMillis());
        calendar.add(Calendar.YEAR, 6);
        simpleDatePicker.setMaxDate(calendar.getTimeInMillis());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View view) {
        int day = simpleDatePicker.getDayOfMonth();
        int month = simpleDatePicker.getMonth() + 1;
        int year = simpleDatePicker.getYear();
        int firstDay = simpleDatePicker.getFirstDayOfWeek();
        Toast.makeText(this, "DAY " + String.valueOf(day) + " MONTH " + String.valueOf(month) +
                        " YEAR " + String.valueOf(year) + " FIRSTDAY OF WEEK " + String.valueOf(firstDay)
                , Toast.LENGTH_LONG).show();
    }
}
