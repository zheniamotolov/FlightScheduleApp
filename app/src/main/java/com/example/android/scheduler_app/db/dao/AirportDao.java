package com.example.android.scheduler_app.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.example.android.scheduler_app.db.entity.Airport;
import com.example.android.scheduler_app.db.entity.AirportSearchResult;

import java.util.List;

@Dao
public interface AirportDao {
    @Query("SELECT * FROM Airport")
    LiveData<List<Airport>> getAllAirportsItems();

    @Query("SELECT * FROM Airport WHERE fs =:airportFs")
    LiveData<Airport> loadAllById(String airportFs);

    @Query("SELECT * FROM Airport WHERE name  =:airportName")
    LiveData<Airport> findByAirportListItemEntityName(String airportName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAirports(List<Airport> airports);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAirport(Airport airport);

    @Delete
    void delete(Airport airport);


}
