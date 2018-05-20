package com.example.android.scheduler_app.db.entity.schedule_entites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlightStatusList {


    @SerializedName("flightStatuses")
    @Expose
    private List<FlightStatus> flightStatuses = null;

    public List<FlightStatus> getFlightStatuses() {
        return flightStatuses;
    }

    public void setFlightStatuses(List<FlightStatus> flightStatuses) {
        this.flightStatuses = flightStatuses;
    }
}
