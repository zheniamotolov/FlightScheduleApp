package com.demo.coursework3;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.coursework3.parser.JSONParser;
import com.demo.coursework3.utilities.NetworkUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;

public class AirportsListActivity extends AppCompatActivity implements AirportsListAdapter.AirportListAdapterOnClickHandler {
    private EditText searchBoxTextView;
    private TextView searchResaultsTextView;
    private TextView errorMessageTextView;
    private ProgressBar loadingIndicatorProgressBar;
    private RecyclerView airportListRecyclerView;

//    private RecyclerView.Adapter recycleAdapter;
//    private LinearLayoutManager layoutManager;
private AirportsListAdapter airportsListAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airports_list);

        searchBoxTextView = (EditText) findViewById(R.id.search_box);
//        searchResaultsTextView = (TextView) findViewById(R.id.search_results_view);
        errorMessageTextView = (TextView) findViewById(R.id.error_message_display);
        loadingIndicatorProgressBar = (ProgressBar) findViewById(R.id.loading_indicator);

        airportListRecyclerView = (RecyclerView) findViewById(R.id.airportsList);
        airportListRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        airportListRecyclerView.setLayoutManager(layoutManager);
        airportsListAdapter = new AirportsListAdapter(this);
        airportListRecyclerView.setAdapter(airportsListAdapter);

    }

    @Override
    public void onClick(String airportsListItemData) {
        Context context = this;
        Toast.makeText(context, airportsListItemData, Toast.LENGTH_SHORT)
                .show();
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
//            Toast.makeText(AirportsListActivity.this, "search message", Toast.LENGTH_LONG).show();
            airportsListAdapter.setAirpotsListData(null);
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
                String[] simpleJsonWeatherData = JSONParser
                        .getPreviewWeatherStringFromJson(AirportsListActivity.this, flightStatsSearchResults);
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
        protected void onPostExecute(String[] airportsData) {
            loadingIndicatorProgressBar.setVisibility(View.INVISIBLE);
            if (airportsData != null) {
                showJsonDataView();
//                searchResaultsTextView.setText(s);
                airportsListAdapter.setAirpotsListData(airportsData);
//                for (String airportString : airportsData) {
//                    searchResaultsTextView.append((airportString) + "\n\n\n");
//                }
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
