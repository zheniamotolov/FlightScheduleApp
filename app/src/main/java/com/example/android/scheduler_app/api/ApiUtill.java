package com.example.android.scheduler_app.api;


import android.util.Log;

import com.example.android.scheduler_app.db.entity.Airport;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android.scheduler_app.constants.Constants.AIRPORT_STATE;
import static com.example.android.scheduler_app.constants.Constants.ALL_AIRPORTS_SEARCH_URL;
import static com.example.android.scheduler_app.constants.Constants.APP_ID;
import static com.example.android.scheduler_app.constants.Constants.APP_KEY;

public class ApiUtill {
    private static FlightStatsService flightStatsService;
        private static List<Airport> airportList;

    public static FlightStatsService getFlightStatsService() {
        return RetrofitClient.getClient(ALL_AIRPORTS_SEARCH_URL).create(FlightStatsService.class);
    }
}