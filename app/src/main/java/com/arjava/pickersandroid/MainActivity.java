package com.arjava.pickersandroid;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.arjava.pickersandroid.pickers.DatePickerFragment;
import com.arjava.pickersandroid.pickers.TimePickerFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDatePicker, btnTimePicker, btnDatePickerSimple, btnTimePickerSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDatePicker = findViewById(R.id.btnDatepicker);
        btnTimePicker = findViewById(R.id.btnTimepicker);
        btnDatePickerSimple = findViewById(R.id.btnDatepickerSimple);
        btnTimePickerSimple = findViewById(R.id.btnTimepickerSimple);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        btnDatePickerSimple.setOnClickListener(this);
        btnTimePickerSimple.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        DialogFragment newFragment;
        Calendar newCalendar = Calendar.getInstance();


        switch (view.getId()){
            case R.id.btnDatepicker:
                //cara 1
                newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "DatePicker");

                break;
            case R.id.btnDatepickerSimple:

                //cara 2

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                    }

                },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
                break;
            case R.id.btnTimepicker:
                //cara 1
                newFragment = new TimePickerFragment();
                newFragment.show(getSupportFragmentManager(), "TimePicker");

                break;
            case R.id.btnTimepickerSimple:

                //cara 2
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hour, int minute) {
                        //ketika waktu telah dipilih
                    }
                },newCalendar.get(Calendar.HOUR_OF_DAY), newCalendar.get(Calendar.MINUTE), android.text.format.DateFormat.is24HourFormat(this));
                timePickerDialog.show();
                break;
        }
    }

}
