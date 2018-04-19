package com.demo.coursework.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AirportDAO {
    @Query("SELECT * FROM airport")
    List<Airport> getAll();

    @Query("SELECT * FROM airport WHERE fs IN (:airportFs)")
    List<Airport> loadAllByIds(int[] airportFs);

    @Query("SELECT * FROM airport WHERE country LIKE :country AND "
            + "city LIKE :city LIMIT 1")
    Airport findByName(String country, String city);

    @Insert
    void insertAll(Airport... airports);

    @Delete
    void delete(Airport airport);
}
