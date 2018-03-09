package com.demo.coursework.activates.airportActivity;

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

import com.demo.coursework.R;
import com.demo.coursework.parser.JSONParser;
import com.demo.coursework.utilities.NetworkUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;

public class AirportsListActivity extends AppCompatActivity implements OnClickHandler {
    private EditText searchBoxTextView;
    private TextView errorMessageTextView;
    private ProgressBar loadingIndicatorProgressBar;
    private RecyclerView airportListRecyclerView;
    private Toast mToast;
    private AirportsListAdapter airportsListAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airports_list);

        searchBoxTextView = (EditText) findViewById(R.id.search_box);
        errorMessageTextView = (TextView) findViewById(R.id.error_message_display);
        loadingIndicatorProgressBar = (ProgressBar) findViewById(R.id.loading_indicator);

        airportListRecyclerView = (RecyclerView) findViewById(R.id.airportsList);
        airportListRecyclerView.setHasFixedSize(true);
        airportListRecyclerView.setItemViewCacheSize(20);
        airportListRecyclerView.setDrawingCacheEnabled(true);
        airportListRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        airportListRecyclerView.setLayoutManager(layoutManager);
        airportsListAdapter = new AirportsListAdapter(this);
        airportListRecyclerView.setAdapter(airportsListAdapter);

    }

    @Override
    public void onClick(String airportsListItemData) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, airportsListItemData, Toast.LENGTH_SHORT);
        mToast.show();

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
                Log.e(e.getMessage(), "exception in building url");
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
        airportListRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showErrorMeassage() {
        errorMessageTextView.setVisibility(View.VISIBLE);
        airportListRecyclerView.setVisibility(View.INVISIBLE);
    }

    //Options in layout menu


}
