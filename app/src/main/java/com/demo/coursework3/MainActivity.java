package com.demo.coursework3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.coursework3.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText searchBox;
    private TextView urlView;
    private TextView searchResaults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchBox = (EditText) findViewById(R.id.search_box);
        urlView = (TextView) findViewById(R.id.url_display);
        searchResaults = (TextView) findViewById(R.id.search_results_view);
    }

    //Network
    void makeflightStatsSearchQuery() {
        String flightStatsQuery = searchBox.getText().toString();
        URL flightStatsSearchURL = NetworkUtils.buildUrl(flightStatsQuery);
        urlView.setText(flightStatsSearchURL.toString());
        String flightStatsSearchResaults = null;

        try {
            flightStatsSearchResaults = NetworkUtils.getResponseFromHttpUrl(flightStatsSearchURL);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //Options in layout menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItemThatWasSelected = item.getItemId();
        if (menuItemThatWasSelected == R.id.action_search) {
//            Toast.makeText(MainActivity.this, "search message", Toast.LENGTH_LONG).show();
            makeflightStatsSearchQuery();
        }
        return super.onOptionsItemSelected(item);
    }
}
