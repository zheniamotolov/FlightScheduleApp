package com.example.android.scheduler_app.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * REST API access points
 */
public interface FlightStatsService {
    @GET(/*"{airportState}"*/"/all?appId=1f0e5057&appKey=df59c0f95bf0805dbb8589f7ebb2c065")
    Call<AirportSearchResponse> getAirports(
            /*@Path("airportsState") String airportState,
            @Query("appId") String appId,
            @Query("appKey") String appKey*/);

}
