package com.example.android.scheduler_app.api;


import com.example.android.scheduler_app.db.entity.schedule_entites.FlightStatusList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * REST API access points
 */
public interface FlightStatsService {
    @GET("/flex/airports/rest/v1/json/active?appId=1f0e5057&appKey=df59c0f95bf0805dbb8589f7ebb2c065")
    Call<AirportSearchResponse> getAirports(
            /*@Path("airportsState") String airportState,
            @Query("appId") String appId,
            @Query("appKey") String appKey*/);
    @GET("/flex/flightstatus/rest/v2/json/airport/status/{airportFs}/dep/2018/5/20/20?appId=1f0e5057&appKey=df59c0f95bf0805dbb8589f7ebb2c065&utc=false&numHours=6&maxFlights=5")
    Call<FlightStatusList> getFlightStatuses(@Path("airportFs") String airportFs);
}
