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
    @GET(/*"{airportState}"*/"/flex/airports/rest/v1/json/all?appId=1f0e5057&appKey=df59c0f95bf0805dbb8589f7ebb2c065")
    Call<AirportSearchResponse> getAirports(
            /*@Path("airportsState") String airportState,
            @Query("appId") String appId,
            @Query("appKey") String appKey*/);

    @GET("/flex/flightstatus/rest/v2/json/airport/status/{airportFS}/dep/2018/5/20/5?appId=1f0e5057&appKey=df59c0f95bf0805dbb8589f7ebb2c065&utc=false&numHours=1&maxFlights=5")
    Call<FlightStatusList> getFlightStatuses(@Path("airportFS") String airportState);

//            @Query("appId") String appId,
//            @Query("appKey") String appKey*/);


}
