package com.arjava.pickersandroid.pickers;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.arjava.pickersandroid.R;

import java.util.Objects;

public class TimePickerActivity extends AppCompatActivity {

    TimePicker timePicker;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        Objects.requireNonNull(getSupportActionBar()).setTitle("TimePickerWidget");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        timePicker = findViewById(R.id.timePickerWidget);
        timePicker.setIs24HourView(true);
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

    public void onClick(View view) {
        int hour;
        int minute;
        if (Build.VERSION.SDK_INT < 23) {
            hour = timePicker.getCurrentHour();
            minute = timePicker.getCurrentMinute();
        } else {
            hour = timePicker.getHour();
            minute = timePicker.getMinute();
        }

        Toast.makeText(this, " HOUR " + String.valueOf(hour) + "\n MINUTE " + minute,
                Toast.LENGTH_LONG).show();
    }
}
