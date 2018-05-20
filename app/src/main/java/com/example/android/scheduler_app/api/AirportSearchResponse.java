package com.example.android.scheduler_app.api;


import android.support.annotation.NonNull;

import com.example.android.scheduler_app.db.entity.Airport;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AirportSearchResponse {
    @SerializedName("airports")
    @Expose
    private List<Airport> airports = null;

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;

    }
}
