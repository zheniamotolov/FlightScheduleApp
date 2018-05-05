package com.demo.coursework.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.demo.coursework.db.model.Airport;

import java.util.List;

@Dao
public interface AirportDao {
    @Query("SELECT * FROM airport")
    List<Airport> getAll();

    @Query("SELECT * FROM airport WHERE fs IN (:airportFs)")
    List<Airport> loadAllByIds(int[] airportFs);

    @Query("SELECT * FROM airport WHERE airportName LIKE :airportName")
    Airport findByAirportName(String airportName);

    @Insert
    void insertAll(Airport... airports);

    @Delete
    void delete(Airport airport);
}
