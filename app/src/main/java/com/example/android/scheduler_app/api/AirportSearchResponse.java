package com.example.android.scheduler_app.api;


import android.support.annotation.NonNull;

import com.example.android.scheduler_app.db.entity.Airport;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AirportSearchResponse {
    @SerializedName("total_count")
    private int total;
    @SerializedName("items")
    private List<Airport> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Airport> getItems() {
        return items;
    }

    public void setItems(List<Airport> items) {
        this.items = items;
    }

    @NonNull
    public List<String> getAirportFs() {
        List<String> airportIds = new ArrayList<>();
        for (Airport airport : items) {
            airportIds.add(airport.getFs());
        }
        return airportIds;
    }
}
