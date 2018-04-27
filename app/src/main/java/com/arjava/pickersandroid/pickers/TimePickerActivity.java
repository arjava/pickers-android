package com.arjava.pickersandroid.pickers;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.arjava.pickersandroid.R;

import java.util.Objects;

public class TimePickerActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        Objects.requireNonNull(getSupportActionBar()).setTitle("TimePickerWidget");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        } else {
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
