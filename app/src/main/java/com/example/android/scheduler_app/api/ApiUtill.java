package com.example.android.scheduler_app.api;


import android.util.Log;

import com.example.android.scheduler_app.db.entity.Airport;

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

    public static List<Airport> flightStatsAirportsLoad() {
        flightStatsService = ApiUtill.getFlightStatsService();
        flightStatsService.getAirports(/*AIRPORT_STATE, APP_ID, APP_KEY*/).enqueue(new Callback<AirportSearchResponse>() {
            @Override
            public void onResponse(Call<AirportSearchResponse> call, Response<AirportSearchResponse> response) {

                if (response.isSuccessful()) {
                    Log.d("FlightStatsApi", "posts loaded from API");
                    airportList = response.body().getItems();
                } else {
                    int statusCode = response.code();
                    Log.d("FlightStatsApi", "error code " + statusCode);

                }
            }

            @Override
            public void onFailure(Call<AirportSearchResponse> call, Throwable t) {
                Log.d("FlightStatsApi", "error loading from API");

            }
        });
        return airportList;

    }
}