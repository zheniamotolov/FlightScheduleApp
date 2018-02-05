package com.demo.coursework3;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.coursework3.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText searchBoxTextView;
    private TextView searchResaultsTextView;
    private TextView errorMessageTextView;
    private ProgressBar loadingIndicatorProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBoxTextView = (EditText) findViewById(R.id.search_box);
        searchResaultsTextView = (TextView) findViewById(R.id.search_results_view);
        errorMessageTextView = (TextView) findViewById(R.id.error_message_display);
        loadingIndicatorProgressBar = (ProgressBar) findViewById(R.id.loading_indicator);

    }


    //Network
    void makeflightStatsSearchQuery() {
        String flightStatsQuery = searchBoxTextView.getText().toString();
        URL flightStatsSearchURL = NetworkUtils.buildUrl(flightStatsQuery);
        String flightStatsSearchResaults = null;
        new FlightStatsQueryTask().execute(flightStatsSearchURL);

    }

    //Async task
    public class FlightStatsQueryTask extends AsyncTask<
            URL,
            Void,
            String> {
        @Override
        protected void onPreExecute() {
            loadingIndicatorProgressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(URL... urls) {
            URL serachURL = urls[0];
            String flightStatsSearchResults = null;
            try {
                flightStatsSearchResults = NetworkUtils.getResponseFromHttpUrl(serachURL);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return flightStatsSearchResults;
        }

        @Override
        protected void onPostExecute(String s) {
            loadingIndicatorProgressBar.setVisibility(View.INVISIBLE);
            if (s != null && !s.equals("")) {

                searchResaultsTextView.setText(s);
            } else {
                showErrorMeassage();
            }
        }
    }

    private void showJsonDataView() {
        errorMessageTextView.setVisibility(View.INVISIBLE);
        searchResaultsTextView.setVisibility(View.VISIBLE);
    }

    private void showErrorMeassage() {
        errorMessageTextView.setVisibility(View.VISIBLE);
        searchResaultsTextView.setVisibility(View.INVISIBLE);
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
