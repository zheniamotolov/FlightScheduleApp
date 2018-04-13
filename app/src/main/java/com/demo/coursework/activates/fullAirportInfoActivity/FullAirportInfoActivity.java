package com.demo.coursework.activates.fullAirportInfoActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.demo.coursework.R;

public class FullAirportInfoActivity extends AppCompatActivity {
    private TextView airportInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_airport_info);
        airportInfo = (TextView) findViewById(R.id.airport_info_display);
        Intent intent = getIntent();
        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            airportInfo.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
        }
    }
}
