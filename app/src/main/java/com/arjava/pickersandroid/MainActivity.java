package com.arjava.pickersandroid;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.arjava.pickersandroid.pickers.DatePickerActivity;
import com.arjava.pickersandroid.pickers.DatePickerFragment;
import com.arjava.pickersandroid.pickers.TimePickerActivity;
import com.arjava.pickersandroid.pickers.TimePickerFragment;
import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.radialtimepicker.RadialTimePickerDialogFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener,
        CalendarDatePickerDialogFragment.OnDateSetListener, RadialTimePickerDialogFragment.OnTimeSetListener {

    TextView textOutput;
    Button btnDatePicker, btnTimePicker, btnDatePickerSimple, btnTimePickerSimple,
            btnDatePickerWidget, btnTimePickerWidget, btnDatePickerLibrary, btnTimePickerLibrary;
    Calendar newCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOutput = findViewById(R.id.textOutput);
        btnDatePicker = findViewById(R.id.btnDatepicker);
        btnTimePicker = findViewById(R.id.btnTimepicker);
        btnDatePickerSimple = findViewById(R.id.btnDatepickerSimple);
        btnTimePickerSimple = findViewById(R.id.btnTimepickerSimple);
        btnDatePickerWidget = findViewById(R.id.btnDatepickerWidget);
        btnTimePickerWidget = findViewById(R.id.btnTimepickerWidget);
        btnDatePickerLibrary = findViewById(R.id.datePickerLibrary);
        btnTimePickerLibrary = findViewById(R.id.timePickerLibrary);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        btnDatePickerSimple.setOnClickListener(this);
        btnTimePickerSimple.setOnClickListener(this);
        btnDatePickerWidget.setOnClickListener(this);
        btnTimePickerWidget.setOnClickListener(this);
        btnDatePickerLibrary.setOnClickListener(this);
        btnTimePickerLibrary.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.datePickerLibrary:

                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setThemeDark()
                        .setOnDateSetListener(MainActivity.this);
                cdp.show(getSupportFragmentManager(), "CalendarDatePickerDialog");
                break;
            case R.id.btnDatepickerWidget:

                startActivity(new Intent(this, DatePickerActivity.class));
                break;
            case R.id.btnDatepicker:

                datePicker(view);
                break;
            case R.id.btnDatepickerSimple:

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, dd MMM yyyy", Locale.getDefault());
                        textOutput.setText(dateFormatter.format(newDate.getTime()));
                    }

                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
                break;
            case R.id.btnTimepickerWidget:

                startActivity(new Intent(this, TimePickerActivity.class));
                break;
            case R.id.btnTimepicker:

                timePicker(view);
                break;
            case R.id.btnTimepickerSimple:

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hour, int minute) {
                        Calendar newTime = Calendar.getInstance();
                        newTime.set(Calendar.HOUR_OF_DAY, hour);
                        newTime.set(Calendar.MINUTE, minute);
                        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm", Locale.getDefault());
                        textOutput.setText(timeFormatter.format(newTime.getTime()));
                    }
                }, newCalendar.get(Calendar.HOUR_OF_DAY), newCalendar.get(Calendar.MINUTE), false);
                timePickerDialog.show();
                break;
            case R.id.timePickerLibrary:

                RadialTimePickerDialogFragment rtpd = new RadialTimePickerDialogFragment()
                        .setOnTimeSetListener(MainActivity.this)
                        .setForced24hFormat();
                rtpd.show(getSupportFragmentManager(), "RadialTimePickerDialog");
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year, month, day);
        setDate(cal);
    }

    private void setDate(final Calendar calendar) {
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        textOutput.setText(dateFormat.format(calendar.getTime()));

    }

    public void datePicker(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "DatePickerDialog");
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        newCalendar.set(Calendar.HOUR_OF_DAY, hour);
        newCalendar.set(Calendar.MINUTE, minute);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm", Locale.getDefault());
        textOutput.setText(timeFormatter.format(newCalendar.getTime()));
    }

    public void timePicker(View view) {
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.show(getSupportFragmentManager(), TimePickerDialog.class.getSimpleName());
    }

    @SuppressLint("StringFormatMatches")
    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        textOutput.setText(getString(R.string.calendar_date_picker, year, monthOfYear+1, dayOfMonth));
    }

    @Override
    public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute) {
        textOutput.setText(getString(R.string.times_radial_picker, hourOfDay, minute));
    }
}