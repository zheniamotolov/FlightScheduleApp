package com.demo.coursework.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Airport.class}, version = 1)
public abstract class AirportDatabase extends RoomDatabase {
    public abstract AirportDAO airportDAO();
}
