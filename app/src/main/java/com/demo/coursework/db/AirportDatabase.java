package com.demo.coursework.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.demo.coursework.db.dao.AirportDao;
import com.demo.coursework.db.model.Airport;

@Database(entities = {Airport.class}, version = 1)
public abstract class AirportDatabase extends RoomDatabase {
    public abstract AirportDao airportDAO();

    private static AirportDatabase INSTANCE;


    public static AirportDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AirportDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AirportDatabase.class, "airport_database")
                            .build();

                }
            }
        }
        return INSTANCE;
    }
}
