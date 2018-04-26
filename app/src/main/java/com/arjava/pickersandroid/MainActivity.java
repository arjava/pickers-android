package com.arjava.pickersandroid;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arjava.pickersandroid.pickers.DatePickerFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDatePicker, btnTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDatePicker = findViewById(R.id.btnDatepicker);
        btnTimePicker = findViewById(R.id.btnTimepicker);
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDatepicker:
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "DatePicker");
                break;
            case R.id.btnTimepicker:

                break;
        }
    }
}
