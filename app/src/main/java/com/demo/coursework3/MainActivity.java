package com.demo.coursework3;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.coursework3.utilities.JSONUtils;
import com.demo.coursework3.utilities.NetworkUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;
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

    //Menu
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

    //Network
    void makeflightStatsSearchQuery() {
        new FlightStatsQueryTask().execute();

    }

    //Async task
    public class FlightStatsQueryTask extends AsyncTask<
            String,
            Void,
            String[]> {
        @Override
        protected void onPreExecute() {
            loadingIndicatorProgressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected String[] doInBackground(String... params) {
//            if (params.length == 0) {
//                return null;
//            }
            try {
                String flightStatsSearchResults = NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl());
                String[] simpleJsonWeatherData = JSONUtils
                        .getPreviewWeatherStringFromJson(MainActivity.this, flightStatsSearchResults);
                return simpleJsonWeatherData;

            } catch (JSONException e) {
                Log.e(e.getMessage(), "Problem with parsing json to string");
            } catch (MalformedURLException e) {
                Log.e(e.getMessage(), "exeption in building url");
            } catch (IOException e) {
                Log.e(e.getMessage(), "Problem with receiving data by url from flightStats");

            }
            return null;
        }

//        private URL builURL() {
//            return NetworkUtils.buildUrl();
//        }


        @Override
        protected void onPostExecute(String[] airportData) {
            loadingIndicatorProgressBar.setVisibility(View.INVISIBLE);
            if (airportData != null) {
                showJsonDataView();
//                searchResaultsTextView.setText(s);
                for (String airportString : airportData) {
                    searchResaultsTextView.append((airportString) + "\n\n\n");
                }
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


}
