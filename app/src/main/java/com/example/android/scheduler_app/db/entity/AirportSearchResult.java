package com.example.android.scheduler_app.db.entity;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "airportsearchresult")
public class AirportSearchResult {
    @NonNull
    @PrimaryKey
    public final String query;

    public final List<String> airportFs;
    public final int totalCount;

    public AirportSearchResult(@NonNull String query, List<String> airportFs, int totalCount) {
        this.query = query;
        this.airportFs = airportFs;
        this.totalCount = totalCount;

    }
}
